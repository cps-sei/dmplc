#define X 4
#define Y 4
#define NEXT 0
#define REQUEST 1
#define WAITING 2
#define MOVE 3

#define assume(_x) __CPROVER_assume(_x)
int nondet_int();

_Bool lock_0_0[X*Y],lock_0_1[X*Y]; //public variable for node 0
int state_0,x_0,y_0,xp_0,yp_0,xf_0,yf_0; //private variables for node 0
_Bool lock_1_0[X*Y],lock_1_1[X*Y]; //public variable for node 1
int state_1,x_1,y_1,xp_1,yp_1,xf_1,yf_1; //private variables for node 0

void INIT()
{
  //node 0 initialization
  state_0 = NEXT;
  x_0 = nondet_int();
  y_0 = nondet_int();
  assume(0 <= x_0 && x_0 < X && 0 <= y_0 && y_0 < Y);
  lock_0_0[x_0 * Y + y_0] = 1;
  xf_0 = nondet_int();
  yf_0 = nondet_int();
  assume(0 <= xf_0 && xf_0 < X && 0 <= yf_0 && yf_0 < Y);

  //node 1 initialization
  state_1 = NEXT;
  x_1 = nondet_int();
  y_1 = nondet_int();
  assume(0 <= x_1 && x_1 < X && 0 <= y_1 && y_1 < Y);
  lock_1_0[x_1 * Y + y_1] = 1;
  xf_1 = nondet_int();
  yf_1 = nondet_int();
  assume(0 <= xf_1 && xf_1 < X && 0 <= yf_1 && yf_1 < Y);

  //distinctness check
  assume(x_0 != x_1 || y_0 != y_1);
}

void CHECK_SAFETY()
{
  assert(x_0 != x_1 || y_0 != y_1);
}

void COPY_FORWARD()
{
  for(int i = 0;i < X*Y;++i) lock_0_1[i] = lock_0_0[i];
  for(int i = 0;i < X*Y;++i) lock_1_1[i] = lock_1_0[i];
}

void COPY_BACKWARD()
{
  for(int i = 0;i < X*Y;++i) lock_0_0[i] = lock_0_1[i];
  for(int i = 0;i < X*Y;++i) lock_1_0[i] = lock_1_1[i];
}
  
void NEXT_XY_0() 
{
  xp_0 = x_0; yp_0 = y_0;
  if(x_0 < xf_0) xp_0 = x_0 + 1;
  else if(x_0 > xf_0) xp_0 = x_0 - 1;
  else if(y_0 < yf_0) yp_0 = y_0 + 1;
  else yp_0 = y_0 - 1;
}

//the code executed by node 0 in each round
void EXECUTE_0()
{
  switch(state_0) {
    //compute next point on route
  case NEXT:
    if(x_0 == xf_0 && y_0 == yf_0) return;
    NEXT_XY_0();
    state_0 = REQUEST;
    break;

    //request the lock but only if it is free
  case REQUEST: 
    if(lock_0_0[xp_0 * Y + yp_0] != 0) return;
    if(lock_1_0[xp_0 * Y + yp_0] != 0) return;
    lock_0_1[xp_0 * Y + yp_0] = 1;
    state_0 = WAITING;
    break;

    //grab the lock if we are the highest 
    //id node to request or hold the lock
  case WAITING:
    if(0 > 0 && lock_0_0[xp_0 * Y + yp_0] != 0) return;
    if(1 > 0 && lock_1_0[xp_0 * Y + yp_0] != 0) return;
    state_0 = MOVE;
    break;

    //now we have the lock on (x’,y’)
  case MOVE:
    //implementation of move_to -- non-determinisatically arrive at
    //the locations (xp_0,yp_0)
    if(nondet_int()) return;
    lock_0_1[x_0 * Y + y_0] = 0; 
    x_0 = xp_0; y_0 = yp_0;
    state_0 = NEXT;
    break;
  }
}
  
void NEXT_XY_1() 
{
  xp_1 = x_1; yp_1 = y_1;
  if(x_1 < xf_1) xp_1 = x_1 + 1;
  else if(x_1 > xf_1) xp_1 = x_1 - 1;
  else if(y_1 < yf_1) yp_1 = y_1 + 1;
  else yp_1 = y_1 - 1;
}

//the code executed by node 1 in each round
void EXECUTE_1()
{
  switch(state_1) {
    //compute next point on route
  case NEXT:
    if(x_1 == xf_1 && y_1 == yf_1) return;
    NEXT_XY_1();
    state_1 = REQUEST;
    break;

    //request the lock but only if it is free
  case REQUEST: 
    if(lock_0_0[xp_1 * Y + yp_1] != 0) return;
    if(lock_1_0[xp_1 * Y + yp_1] != 0) return;
    lock_1_1[xp_1 * Y + yp_1] = 1;
    state_1 = WAITING;
    break;

    //grab the lock if we are the highest 
    //id node to request or hold the lock
  case WAITING:
    if(0 > 1 && lock_0_0[xp_1 * Y + yp_1] != 0) return;
    if(1 > 1 && lock_1_0[xp_1 * Y + yp_1] != 0) return;
    state_1 = MOVE;
    break;

    //now we have the lock on (x’,y’)
  case MOVE:
    //implementation of move_to -- non-determinisatically arrive at
    //the locations (xp_1,yp_1)
    if(nondet_int()) return;
    lock_1_1[x_1 * Y + y_1] = 0; 
    x_1 = xp_1; y_1 = yp_1;
    state_1 = NEXT;
    break;
  }
}

int main()
{
  INIT();
  for(int r = 0;r < R;++r) {
    CHECK_SAFETY();
    COPY_FORWARD();
    EXECUTE_0();
    EXECUTE_1();
    COPY_BACKWARD();
  }

  return 0;
}
