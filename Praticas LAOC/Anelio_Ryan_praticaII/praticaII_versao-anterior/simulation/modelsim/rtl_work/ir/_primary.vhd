library verilog;
use verilog.vl_types.all;
entity ir is
    port(
        din             : in     vl_logic_vector(15 downto 0);
        ir_in           : in     vl_logic;
        clock           : in     vl_logic;
        reg_ir          : out    vl_logic_vector(15 downto 0);
        reg_rx          : out    vl_logic_vector(3 downto 0);
        reg_ry          : out    vl_logic_vector(3 downto 0)
    );
end ir;
