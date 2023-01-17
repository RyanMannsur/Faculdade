transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/projeto1/fluxo_de_dados {C:/Users/ryane/OneDrive/Documentos/atividades/projeto1/fluxo_de_dados/farol.v}

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/projeto1/fluxo_de_dados {C:/Users/ryane/OneDrive/Documentos/atividades/projeto1/fluxo_de_dados/farol.v}

vsim -t 1ps -L altera_ver -L lpm_ver -L sgate_ver -L altera_mf_ver -L altera_lnsim_ver -L cycloneii_ver -L stratixii_ver -L rtl_work -L work -voptargs="+acc"  farol

add wave *
view structure
view signals
run -all
