package com.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "lastname", nullable = false, length = 30)
    val lastname: String,

    @Column(name = "firstname", nullable = false, length = 30)
    val firstname: String,

    @Column(name = "surname", nullable = false, length = 30)
    val surname: String,

    @Column(name = "telegram", length = 30)
    val telegram: String?,

    @Column(name = "phone", length = 15)
    val phone: String?,

    @Column(name = "email", length = 50)
    val email: String?,

    @Column(name = "git", length = 50)
    val git: String?
)

