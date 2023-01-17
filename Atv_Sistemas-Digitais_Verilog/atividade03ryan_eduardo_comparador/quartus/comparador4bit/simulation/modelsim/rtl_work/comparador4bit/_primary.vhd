library verilog;
use verilog.vl_types.all;
entity comparador4bit is
    port(
        A               : in     vl_logic_vector(3 downto 0);
        B               : in     vl_logic_vector(3 downto 0);
        igual           : out    vl_logic;
        maior           : out    vl_logic;
        menor           : out    vl_logic
    );
end comparador4bit;
