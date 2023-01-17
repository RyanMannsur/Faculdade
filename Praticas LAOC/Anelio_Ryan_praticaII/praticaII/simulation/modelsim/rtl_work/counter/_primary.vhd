library verilog;
use verilog.vl_types.all;
entity counter is
    port(
        address         : in     vl_logic_vector(4 downto 0);
        pc_inc          : in     vl_logic;
        pc_in           : in     vl_logic;
        buswires        : in     vl_logic_vector(15 downto 0);
        r7              : out    vl_logic_vector(15 downto 0)
    );
end counter;
