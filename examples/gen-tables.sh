#!/bin/bash

# print preamble
cat <<EOF
\begin{figure}[t]
\\centering
{\\scriptsize
EOF

#compute mean median etc
function comp_stats {
    PREF="$1"
    STF="$2"
    paste -d ',' $STF".--seq-sem/stats" $STF".--seq-dbl/stats" | \
        grep "$PREF," | while read line; do
        local -a row=()
        IFS=', ' read -a row <<< $line
        if [ ${row[4]} != "UNK" ] && [ ${row[9]} != "UNK" ]; then 
            rat=$(echo "${row[3]} / ${row[8]}" | bc -l)
        fi
        #echo ${row[4]},${row[9]},${row[3]},${row[8]},$rat
        echo $rat
    done | Rscript -e 'd<-scan("stdin", quiet=TRUE); cat(mean(d), sd(d), sep=",")'
}

#generate sub table
function sub_table {
    NV="$2"
    RV="$3"
    PREF="$4"
    STF="$5"
    ROWCOL="$6"

    #ratios of verification times
    local -a stats
    IFS=', ' read -a stats <<< $(comp_stats $PREF $STF)

    if [ "$ROWCOL" == "1" ]; then
        cat <<EOF
\begin{tabular}{|c|c|c|c|c|c|c|}
\hline \multicolumn{7}{|c|}{$1} \\\\
\hline \$R\$ & \$T_S\$ & \$T_D\$ & \$T_S\$ & \$T_D\$ & \$T_S\$ & \$T_D\$ \\\\
EOF
    else
        cat <<EOF
\begin{tabular}{|c|c|c|c|c|c|}
\hline \multicolumn{6}{|c|}{$1} \\\\
\hline \$T_S\$ & \$T_D\$ & \$T_S\$ & \$T_D\$ & \$T_S\$ & \$T_D\$ \\\\
EOF
    fi

    #generate top row
    TOP=""
    for N in $NV; do
        if [ "x$TOP" == "x" ]; then
            if [ "$ROWCOL" == "1" ]; then
                TOP='\hline & \multicolumn{2}{c|}{$n='$N'$}'      
            else
                TOP='\hline \multicolumn{2}{|c|}{$n='$N'$}'      
            fi
        else
            TOP=$TOP' & \multicolumn{2}{c|}{$n='$N'$}'
        fi
    done
    TOP=$TOP' \\'
    echo $TOP

    local -a ROWS
    for N in $NV; do    
        for R in $RV; do
            IFS=', ' read -a sem <<< $(grep "$PREF,$N,$R," $STF".--seq-sem/stats")
            if [ "${sem[4]}" == "UNK" ]; then
                sem[3]='--'
            else
                sem[3]=$(printf "%.0f" ${sem[3]})
            fi
            IFS=', ' read -a dbl <<< $(grep "$PREF,$N,$R," $STF".--seq-dbl/stats")
            if [ "${dbl[4]}" == "UNK" ]; then
                dbl[3]='--'
            else
                dbl[3]=$(printf "%.0f" ${dbl[3]})
            fi
            X=$(printf "%s & %s\n" "${sem[3]}" "${dbl[3]}")

            if [ "x${ROWS[${R}]}" == "x" ]; then
                if [ "$ROWCOL" == "1" ]; then
                    ROWS[${R}]=$R" & "$X        
                else
                    ROWS[${R}]=$X        
                fi
            else
                ROWS[${R}]=${ROWS[${R}]}" & "$X        
            fi
        done
    done
    for R in $RV; do
        echo '\hline '${ROWS[${R}]}' \\'
    done

    if [ "$ROWCOL" == "1" ]; then
        printf "\\hline & \multicolumn{6}{c|}{$\\mu$=%.3f $\\sigma$=%.3f} %s\n" ${stats[0]} ${stats[1]} '\\'
    else
        printf "\\hline \multicolumn{6}{|c|}{$\\mu$=%.3f $\\sigma$=%.3f} %s\n" ${stats[0]} ${stats[1]} '\\'
    fi
    printf "\\hline \n\\%s{tabular}\n" 'end'
}

echo '\begin{tabular}{ccc}'
sub_table "MUTEX-OK" "6 8 10" "60 80 100" \
"mutex.ok" "results/brunch.out.mutex.ok" "1"
echo '&'
sub_table "MUTEX-BUG1" "6 8 10" "60 80 100" \
"mutex.bug1" "results/brunch.out.mutex.bug1" "0"
echo '&'
sub_table "MUTEX-BUG2" "6 8 10" "60 80 100" \
"mutex.bug2" "results/brunch.out.mutex.bug2" "0"
echo '\end{tabular}'

echo '\hspace*{-0.25in}'
echo '\begin{tabular}{cccc}'
G="4"
sub_table "3DCOLL-OK-${G}x${G}" "2 4 6" "10 20 30" \
    "coll.3d.opt.ok.${G}.${G}" "results/brunch.out.coll.3d.opt.ok" "1"
echo '&'
G="7"
sub_table "3DCOLL-OK-${G}x${G}" "2 4 6" "10 20 30" \
    "coll.3d.opt.ok.${G}.${G}" "results/brunch.out.coll.3d.opt.ok" "0"
echo '&'
G="4"
sub_table "3DCOLL-BUG-${G}x${G}" "2 4 6" "10 20 30" \
    "coll.3d.opt.bug1.${G}.${G}" "results/brunch.out.coll.3d.opt.bug1" "0"
echo '&'
G="7"
sub_table "3DCOLL-BUG-${G}x${G}" "2 4 6" "10 20 30" \
    "coll.3d.opt.bug1.${G}.${G}" "results/brunch.out.coll.3d.opt.bug1" "0"
echo '\end{tabular}'

for G in 4 7; do
    echo '\begin{tabular}{ccc}'
    sub_table "2DCOLL-OK-${G}x${G}" "2 4 6" "10 20 30" \
        "coll.ok.${G}.${G}" "results/brunch.out.coll.ok" "1"
    echo '&'
    sub_table "2DCOLL-BUG1-${G}x${G}" "2 4 6" "10 20 30" \
        "coll.bug1.${G}.${G}" "results/brunch.out.coll.bug1" "0"
    echo '&'
    sub_table "2DCOLL-BUG2-${G}x${G}" "2 4 6" "10 20 30" \
        "coll.bug2.${G}.${G}" "results/brunch.out.coll.bug2" "0"
    echo '\end{tabular}'
done

#print postamble
cat <<EOF
}
\caption{Experimental Results; \$T_S\$, \$T_D\$ = verification 
time with \$\seqsem\$, \$\seqdbl\$; \$n\$ = no. of nodes; 
\$R\$ = no. of rounds; \$G \times G\$ = grid size; 
\$\mu\$, \$\sigma\$ = mean, standard deviation of \$T_D/T_D\$
for all experiments in that category; -- mean out of 
time/memory.}
\label{tab:exp}
\end{figure}
EOF

