package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({

  describe("Baufest") {
    val responsable1 = Empleado(150.0)
    val responsable2 = Empleado(120.0)
    val responsable3 = Empleado(180.0)
    val responsable4 = Empleado(200.0)
    val empleado1 = Empleado(100.0)
    val empleado2 = Empleado(80.0)
    val empleado3 = Empleado(90.0)
    val tareaSimple1 = Simple(5, responsable1, listOf(empleado1, empleado2), 500.0)
    val tareaSimple2 = Simple(3, responsable2, listOf(empleado3), 200.0)
    val tareaDeIntegracion1 = DeIntegracion(responsable3, listOf(tareaSimple1))
    val tareaDeIntegracion2 = DeIntegracion(responsable4, listOf(tareaDeIntegracion1, tareaSimple2))

    describe("Una tarea") {
      describe("simple") {
        it("tiene una nomina de 3 empleados (incluido el responsable") {
          tareaSimple1.nominaDeEmpleados().shouldContainExactlyInAnyOrder(empleado1, empleado2, responsable1)
        }
        it("sabe cuantas horas se necesitan para finalizar la tarea") {
          tareaSimple1.horasNecesariasParaFinalizacion().shouldBe(2)
        }
        it("sabe su costo") {
          tareaSimple1.costoDeTarea().shouldBe(1610)
        }
      }

      describe("de integracion") {
        it("tiene una nomina de 7 empleados (incluidos los responsables") {
          tareaDeIntegracion2.nominaDeEmpleados().shouldContainExactlyInAnyOrder(empleado1, empleado2, empleado3, responsable1, responsable2, responsable3, responsable4)
        }
      }
    }
  }
})
