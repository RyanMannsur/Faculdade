library verilog;
use verilog.vl_types.all;
entity mux_41 is
    port(
        I0              : in     vl_logic;
        I1              : in     vl_logic;
        I2              : in     vl_logic;
        I3              : in     vl_logic;
        selA            : in     vl_logic;
        selB            : in     vl_logic;
        saida           : out    vl_logic
    );
end mux_41;
