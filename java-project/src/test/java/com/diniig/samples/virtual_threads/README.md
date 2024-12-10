# regular thread dump
`jstack <PID>`
# thred dump with virtual threads
`jcmd <PID> Thread.dump_to_file -format=text jcmd.dump.1`