library verilog;
use verilog.vl_types.all;
entity toplevel is
    port(
        clock           : in     vl_logic;
        data            : in     vl_logic_vector(7 downto 0);
        address         : in     vl_logic_vector(4 downto 0);
        wren            : in     vl_logic;
        q               : out    vl_logic_vector(7 downto 0)
    );
end toplevel;
