/**
 * To run SPIN use the command:
 * spin -a example-01.pml && gcc -DSAFETY -o pan pan.c && time ./pan
 */

#define N 2
#define X 3
#define Y 3

#define NEXT 0
#define REQUEST 1
#define WAITING 2
#define MOVE 3

typedef LOCK1 { bool d[N]; };
typedef LOCK2 { LOCK1 d[Y]; }
typedef COORD { byte x; byte y; };

LOCK2 locks[X], locks_f[X];
COORD pos[N];
COORD posp[N];
COORD posf[N];
byte state[N];
 
inline myselect(a,b,r)
{
  atomic {
    r = a;
    do
      ::(r<b) -> r++;
      ::break;
    od
  }
}

inline get_lock(_x,_y,_i,_r) { _r = locks[_x].d[_y].d[_i]; }
inline set_lock(_x,_y,_i,_r) { locks[_x].d[_y].d[_i] = _r; }
inline get_lock_f(_x,_y,_i,_r) { _r = locks_f[_x].d[_y].d[_i]; }
inline set_lock_f(_x,_y,_i,_r) { locks_f[_x].d[_y].d[_i] = _r; }
inline nondet_bool(_r) { select(b:0..1); }

inline next_xy(id)
{
  atomic{
    posp[id].x = pos[id].x;
    posp[id].y = pos[id].y;
    if
      ::(pos[id].x < posf[id].x) -> posp[id].x = pos[id].x+1;
      ::(pos[id].x > posf[id].x) -> posp[id].x = pos[id].x-1;
      ::(pos[id].x == posf[id].x) && (pos[id].y < posf[id].y) -> posp[id].y = pos[id].y+1;
      ::(pos[id].x == posf[id].x) && (pos[id].y > posf[id].y) -> posp[id].y = pos[id].y-1;
    fi
  }
}

inline exists_lower(_id,_nd)
{
  atomic {
    _nd = false;
    byte i = 0;
    bool l = 0;
    do
      :: (i >= _id) -> break;
      :: (i < _id) ->
         get_lock(posp[_id].x,posp[_id].y,i,l)
         if
           ::l -> _nd = true; break;
           ::!l -> skip;
         fi    
         i++;
    od
  }
}

inline exists_higher(_id,_nd)
{
  atomic{
    _nd = false;
    byte i = _id+1;
    bool l = 0;
    do
      :: (i >= N) -> break;
      :: (i < N) ->
         get_lock(posp[_id].x,posp[_id].y,i,l)
         if
           ::l -> _nd = true; break;
           ::!l -> skip;
         fi    
         i++;
    od
  }
}

inline init_state()
{
  atomic {
    byte i = 0, j = 0;

    /* initialize positions and locks */
    do
      :: (i >= N) -> break;
      :: (i < N) ->
         myselect(0,X-1,pos[i].x);
         myselect(0,Y-1,pos[i].y);
         myselect(0,X-1,posf[i].x);
         myselect(0,Y-1,posf[i].y);
         set_lock(pos[i].x,pos[i].y,i,1);
         state[i] = NEXT;
         i++;
    od
    
    /* make sure no collisions initially */
    i = 0;
    do
      :: (i >= N) -> break;
      :: (i < N) -> {
        j = i+1;
        do
          :: (j >= N) -> break;
          :: (j < N) ->
end:         (pos[i].x != pos[j].x || pos[i].y != pos[j].y);
             j++;
        od
        i++;
      }
    od  
  }
}

inline copy_fwd()
{
  atomic {
    byte i = 0, j = 0, k = 0;
    bool l = 0;
    
    /* copy locks */
    i = 0;
    do
      :: (i >= X) -> break;
      :: (i < X) -> {
        j = 0;
        do
          :: (j >= Y) -> break;
          :: (j < Y) -> {
            k = 0;
            do
              :: (k >= N) -> break;
              :: (k < N) -> {
                get_lock(i,j,k,l);
                set_lock_f(i,j,k,l);
                k++;
              }
            od
            j++;
          }
        od
        i++;
      }
    od  
  }
}

inline copy_back()
{
  atomic{
    byte i = 0, j = 0, k = 0;
    bool l = 0;
    
    /* copy locks */
    i = 0;
    do
      :: (i >= X) -> break;
      :: (i < X) -> {
        j = 0;
        do
          :: (j >= Y) -> break;
          :: (j < Y) -> {
            k = 0;
            do
              :: (k >= N) -> break;
              :: (k < N) -> {
                get_lock_f(i,j,k,l);
                set_lock(i,j,k,l);
                k++;
              }
            od
            j++;
          }
        od
        i++;
      }
    od  
  }
}

inline check_safety()
{
  atomic {
    byte i = 0, j = 0;
    /* make sure no collisions */
    i = 0;
    do
      :: (i >= N) -> break;
      :: (i < N) -> {
        j = i+1;
        do
          :: (j >= N) -> break;
          :: (j < N) ->
             assert(pos[i].x != pos[j].x || pos[i].y != pos[j].y);
             j++;
        od
        i++;
      }
    od
  }
}

inline run_node_round(id)
{
  atomic{
    bool nd = 0;
    if
      :: state[id] == NEXT -> {
        nd = (pos[id].x == posf[id].x && pos[id].y == posf[id].y);
        if
          ::nd -> skip;
          ::!nd ->
             next_xy(id);
             state[id] = REQUEST;
        fi
      }
      :: state[id] == REQUEST -> {
        exists_lower(id,nd);
        if
          ::nd -> skip;
          ::!nd -> {
            set_lock_f(posp[id].x, posp[id].y, id, 1);
            state[id] = WAITING;
          }
        fi
      }
      :: state[id] == WAITING -> {
        exists_higher(id,nd);
        if
          ::nd -> skip;
          ::!nd -> state[id] = MOVE;
        fi      
      }
      :: state[id] == MOVE -> {
        myselect(0,1,nd); //GRID_MOVE()
        if
          ::nd -> skip;
          ::!nd -> {
            set_lock_f(pos[id].x, pos[id].y, id, 0);
            pos[id].x = posp[id].x;
            pos[id].y = posp[id].y;
            state[id] = NEXT;
          }
        fi
      }
    fi
  }
}

active proctype main()
{
  byte ii = 0;
  init_state();
  do
  ::atomic{
    check_safety();
    copy_fwd();
    /* make sure no collisions */
    ii = 0;
    do
      :: (ii >= N) -> break;
      :: (ii < N) -> {
        run_node_round(ii);
        ii++;
      }
    od
    copy_back();
  }
  od
}
