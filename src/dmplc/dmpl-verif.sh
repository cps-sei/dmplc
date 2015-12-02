#!/bin/bash

function usage {
    echo "Usage : dmpl-verif.sh [-args] file.verif [output.log]"
    echo "  Optional Arguments:"
    echo "    -b  | --force-seq    Fully sequentialize and verify"
    echo "    -B  | --seq-only     Only sequentialize, don't verify"
    echo "    -I  | --force-ind    Force inductive verification"
    echo "    -R  | --round R      Force verification with R rounds"
}

#flags
FORCEBUILD=0
BUILDONLY=0
INDUCTIVE=0
IND_ROUND=""
argc=0

#get flags
while true; do
    case "$1" in
        -b|--force-seq)
            FORCEBUILD=1
            ;;
        -B|--seq-only)
            BUILDONLY=1
            ;;
        -I|--force-ind)
            INDUCTIVE=1
            ;;
        -R|--round)
            shift
            IND_ROUND="$1"
            ;;
        "")
            break
            ;;
        *)
            case "$argc" in
                0)
                    VERIF="$1"
                    ;;
                1)
                    OUTLOG="$1"
                    ;;
                *)
                    echo Unexpected argument: $1
                    usage
                    exit 1
            esac
            argc=$((argc+1))
            ;;
    esac
    shift
done

#set output log file
if [ "x$OUTLOG" == "x" ]; then
    OUTLOG="/dev/null"
else
    touch $OUTLOG
fi

if [ -z "$VERIF" ]; then
    echo No .verif file specified
    usage
    exit 1
fi

#source the verif file
source $VERIF

#update rounds if forced by command line
if [ "x$IND_ROUND" != "x" ]; then ROUNDS=$IND_ROUND; fi

CFILE="$(basename $VERIF)_$VERIF_NAME.c"

#create the DMPLC command line
CMD="dmplc --roles $ROLEDESC --cube-grid $GRIDSIZE -r $ROUNDS"
CMD+=" -rp $PROPERTY -o $CFILE $DMPL"

if [ $INDUCTIVE == "1" ] || [ "$VERIF" == "inductive" ]; then
    CMD+=" -si"
elif [ "$VERIF" == "bounded" ]; then
    CMD+=" -s"
else
    echo "ERROR: illegal verification type $VERIF!!" && \
    echo "ERROR: legal values are bounded and inductive!!" && exit 1
fi

if [ $FORCEBUILD -eq 1 ] || [ $DMPL -nt $CFILE ]; then
    echo "========== running dmplc =========" >> $OUTLOG
    echo $CMD >> $OUTLOG
    $CMD 2>&1 >> $OUTLOG
    if [ "$?" != "0" ]; then
        echo "ERROR: dmplc failed on $DMPL!!"
        echo "Command Line: $CMD"
        exit 1
    fi
fi

#if we don't have to verify we are done
[ "$BUILDONLY" -eq 1 ] && exit 0

if [ $INDUCTIVE == "1" ] || [ "$VERIF" == "inductive" ]; then
    printf "verification %30s : " $VERIF_NAME
else
    printf "induct verif %30s : " $VERIF_NAME
fi

CMD="cbmc $CFILE"
echo "========== running cbmc =========" >> $OUTLOG
echo $CMD >> $OUTLOG
RES=$($CMD 2>&1 | tee -a $OUTLOG | grep VERIFICATION | awk '{print $2}')

if [ "$RES" == "$OUT" ]; then
    echo "$RES (expected)"
else
    echo "$RES (unexpected)"
fi

