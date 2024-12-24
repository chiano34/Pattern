package com.example.demo.controller

import com.example.demo.entity.Student
import com.example.demo.repository.StudentRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class StudentController(val studentRepository: StudentRepository) {

    @GetMapping("/students")
    fun student_list(
        model: Model,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): String {
        val pageable: Pageable = PageRequest.of(page, size)
        val studentPage = studentRepository.findAll(pageable)
        val formattedStudents = format_student(studentPage.content)

        populate_model(model, formattedStudents, page, studentPage.totalPages)
        return "students"
    }

    private fun format_student(students: List<Student>): List<Map<String, String>> {
        return students.map { student ->
            mapOf(
                "id" to student.id.toString(),
                "fullname" to format_fullName(student),
                "git" to student.git.orEmpty(),
                "contact" to format_contact(student)
            )
        }
    }

    private fun format_fullName(student: Student): String {
        return "${student.lastname} ${student.firstname.firstOrNull() ?: ""}.${student.surname?.firstOrNull() ?: ""}."
    }

    private fun format_contact(student: Student): String {
        return student.telegram ?: student.phone ?: student.email ?: "N/A"
    }

    private fun populate_model(model: Model, students: List<Map<String, String>>, currentPage: Int, totalPages: Int) {
        model.addAttribute("students", students)
        model.addAttribute("currentPage", currentPage)
        model.addAttribute("totalPages", totalPages)
    }
}
