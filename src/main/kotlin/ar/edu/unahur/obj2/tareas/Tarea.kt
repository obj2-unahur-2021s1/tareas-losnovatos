package ar.edu.unahur.obj2.tareas

abstract class Tarea(val horasEstimadasDeFinalizacion:Double,val responsable:Empleado,val empleadosAsignados: List<Empleado>?,val costoInfraestructura:Double){//la lista de empleados la hago anulable para probar despues heredar sin cargarle nada
    abstract fun horasNecesariasParaFinalizacion():Double
    fun costo()=costoInfraestructura+sueldoEmpleados()+sueldoResponsable()
    abstract fun sueldoEmpleados():Double
    abstract fun sueldoResponsable():Double



}
class Empleado(val sueldoPorHora:Int)
