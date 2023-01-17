library verilog;
use verilog.vl_types.all;
entity farol is
    port(
        F               : in     vl_logic;
        C               : in     vl_logic;
        P               : in     vl_logic;
        S               : out    vl_logic
    );
end farol;
