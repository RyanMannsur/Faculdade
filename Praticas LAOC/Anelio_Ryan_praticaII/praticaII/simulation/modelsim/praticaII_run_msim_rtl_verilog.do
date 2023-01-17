transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/fsm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/romlpm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/ramlpm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/ir.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/mux.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/a.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/alu.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/g.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/addr.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/dout.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/counter.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/registrador.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/processador.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/b.v}

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/praticaII/test_bench.v}

vsim -t 1ps -L altera_ver -L lpm_ver -L sgate_ver -L altera_mf_ver -L altera_lnsim_ver -L cycloneii_ver -L rtl_work -L work -voptargs="+acc"  test_bench

add wave *
view structure
view signals
run -all
