library verilog;
use verilog.vl_types.all;
entity processador is
    port(
        run             : in     vl_logic;
        resetn          : in     vl_logic;
        clock           : in     vl_logic;
        done            : out    vl_logic;
        r0              : out    vl_logic_vector(15 downto 0);
        r1              : out    vl_logic_vector(15 downto 0);
        r2              : out    vl_logic_vector(15 downto 0);
        r3              : out    vl_logic_vector(15 downto 0)
    );
end processador;
