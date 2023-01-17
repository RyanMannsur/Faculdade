library verilog;
use verilog.vl_types.all;
entity registrador_4bit is
    port(
        Q0              : out    vl_logic;
        Q1              : out    vl_logic;
        Q2              : out    vl_logic;
        Q3              : out    vl_logic;
        \in\            : in     vl_logic;
        reset           : in     vl_logic;
        clock           : in     vl_logic
    );
end registrador_4bit;
