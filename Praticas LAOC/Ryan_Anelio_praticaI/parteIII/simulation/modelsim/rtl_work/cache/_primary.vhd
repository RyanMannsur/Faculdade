library verilog;
use verilog.vl_types.all;
entity cache is
    port(
        clock           : in     vl_logic;
        clk             : in     vl_logic;
        address         : in     vl_logic_vector(4 downto 0);
        wren            : in     vl_logic;
        hit             : out    vl_logic;
        valido          : out    vl_logic;
        LRU             : out    vl_logic;
        dirty           : out    vl_logic;
        data            : in     vl_logic_vector(2 downto 0);
        q               : out    vl_logic_vector(2 downto 0)
    );
end cache;
