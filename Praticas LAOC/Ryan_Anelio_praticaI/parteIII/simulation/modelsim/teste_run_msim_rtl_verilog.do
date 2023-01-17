transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2 {C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2/decodificador_c.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2 {C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2/ramlpm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2 {C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2/toplevel.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2 {C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2/cache.v}

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2 {C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2/test_bench.v}

vsim -t 1ps -L altera_ver -L lpm_ver -L sgate_ver -L altera_mf_ver -L altera_lnsim_ver -L cycloneii_ver -L rtl_work -L work -voptargs="+acc"  test_bench

add wave *
view structure
view signals
run -all
