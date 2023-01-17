transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/atividade03ryan_eduardo_comparador/quartus/comparador4bit {C:/Users/ryane/OneDrive/Documentos/atividades/atividade03ryan_eduardo_comparador/quartus/comparador4bit/comparador4bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/atividade03ryan_eduardo_comparador/quartus/comparador4bit {C:/Users/ryane/OneDrive/Documentos/atividades/atividade03ryan_eduardo_comparador/quartus/comparador4bit/comparador1bit.v}

