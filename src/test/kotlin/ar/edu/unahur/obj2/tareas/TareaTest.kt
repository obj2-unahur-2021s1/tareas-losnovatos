package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({

  describe("Baufest") {
    val responsable = Empleado(150.0)
    val empleado1 = Empleado(100.0)
    val empleado2 = Empleado(80.0)
    val tareaSimple = Simple(5, responsable, listOf(empleado1, empleado2), 500.0)

    describe("Una tarea") {
      describe("simple") {
        it("tiene una nomina de 3 empleados (incluido el responsable") {
          tareaSimple.nominaDeEmpleados().shouldContainExactlyInAnyOrder(empleado1, empleado2, responsable)
        }
        it("sabe cuantas horas se necesitan para finalizar la tarea") {
          tareaSimple.horasNecesariasParaFinalizacion().shouldBe(2)
        }
        it("sabe su costo") {
          tareaSimple.costoDeTarea().shouldBe(1610)
        }
      }
    }
  }
})
