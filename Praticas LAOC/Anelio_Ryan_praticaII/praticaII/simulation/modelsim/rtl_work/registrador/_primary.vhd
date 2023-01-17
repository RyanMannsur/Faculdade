library verilog;
use verilog.vl_types.all;
entity registrador is
    port(
        buswires        : in     vl_logic_vector(15 downto 0);
        clock           : in     vl_logic;
        mvt             : in     vl_logic;
        r_in            : in     vl_logic;
        data_r          : out    vl_logic_vector(15 downto 0)
    );
end registrador;
