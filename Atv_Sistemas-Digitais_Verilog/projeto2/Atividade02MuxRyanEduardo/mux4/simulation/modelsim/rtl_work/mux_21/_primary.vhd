library verilog;
use verilog.vl_types.all;
entity mux_21 is
    port(
        I0              : in     vl_logic;
        I1              : in     vl_logic;
        sel             : in     vl_logic;
        saida           : out    vl_logic
    );
end mux_21;
