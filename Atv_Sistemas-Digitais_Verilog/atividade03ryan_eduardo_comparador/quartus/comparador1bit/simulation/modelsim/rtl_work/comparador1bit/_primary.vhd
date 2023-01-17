library verilog;
use verilog.vl_types.all;
entity comparador1bit is
    port(
        enable          : in     vl_logic;
        A               : in     vl_logic;
        B               : in     vl_logic;
        maior           : out    vl_logic;
        menor           : out    vl_logic;
        igual           : out    vl_logic
    );
end comparador1bit;
