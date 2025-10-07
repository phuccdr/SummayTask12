package com.eco.summaytask12.repository.datastorage

import com.eco.summaytask12.extension.stringToDate
import com.eco.summaytask12.model.project.Project

 object MockProjectData {
    val projects = mutableListOf(
        // Completed Projects
        Project(
            name = "EcoMobile Banking App",
            description = "Mobile banking application with advanced security features and real-time transactions",
            startDate = ("15/01/2020").stringToDate(),
            estimateTimeMonth = 6f,
            endDateActual = ("25/01/2021").stringToDate(),
            progress = 100f
        ),
        Project(
            name = "E-Commerce Platform",
            description = "Full-featured e-commerce platform with AI-powered product recommendations",
            startDate = ("01/03/2019").stringToDate(),
            estimateTimeMonth = 8f,
            endDateActual = ("05/05/2024").stringToDate(),
            progress = 100f
        ),
        Project(
            name = "Health Tracking App",
            description = "Personal health monitoring app with fitness tracking and diet planning",
            startDate = ("15/05/2020").stringToDate(),
            estimateTimeMonth = 4f,
            endDateActual = ("18/08/2025").stringToDate(),
            progress = 100f
        ),
        
        // In-Progress Projects
        Project(
            name = "Smart Home Controller",
            description = "IoT-based smart home automation and control system",
            startDate = ("01/08/2022").stringToDate(),
            estimateTimeMonth = 5f,
            endDateActual = null,
            progress = 75f
        ),
        Project(
            name = "Food Delivery App",
            description = "Real-time food delivery service with GPS tracking and multiple payment options",
            startDate = ("15/09/2025").stringToDate(),
            estimateTimeMonth = 6f,
            endDateActual = null,
            progress = 60f
        ),
        Project(
            name = "Learning Management System",
            description = "Online education platform with video streaming and interactive quizzes",
            startDate = ("08/01/2023").stringToDate(),
            estimateTimeMonth = 7f,
            endDateActual = null,
            progress = 45f
        ),
        
        // Recently Started Projects
        Project(
            name = "Travel Booking App",
            description = "Comprehensive travel booking platform for flights, hotels, and tours",
            startDate = ("16/01/2018").stringToDate(),
            estimateTimeMonth = 9f,
            endDateActual = null,
            progress = 30f
        ),
        Project(
            name = "Social Media Dashboard",
            description = "Analytics and management tool for multiple social media platforms",
            startDate = ("06/06/2024").stringToDate(),
            estimateTimeMonth = 5f,
            endDateActual = null,
            progress = 15f
        ),
        Project(
            name = "Inventory Management System",
            description = "Enterprise-level inventory tracking and warehouse management solution",
            startDate = ("15/01/2022").stringToDate(),
            estimateTimeMonth = 6f,
            endDateActual = null,
            progress = 20f
        ),
        Project(
            name = "Video Streaming Platform",
            description = "Netflix-like video streaming service with personalized content recommendations",
            startDate = ("16/01/2025").stringToDate(),
            estimateTimeMonth = 10f,
            endDateActual = null,
            progress = 10f
        ),
        
        // New Projects
        Project(
            name = "Cryptocurrency Wallet",
            description = "Secure digital wallet for managing multiple cryptocurrencies",
            startDate = ("08/01/2017").stringToDate(),
            estimateTimeMonth = 8f,
            endDateActual = null,
            progress = 5f
        ),
        Project(
            name = "AI Chatbot Assistant",
            description = "Intelligent chatbot with natural language processing for customer support",
            startDate = ("09/09/2020").stringToDate(),
            estimateTimeMonth = 4f,
            endDateActual = null,
            progress = 8f
        ),
        Project(
            name = "Fleet Management System",
            description = "GPS-based vehicle tracking and fleet management for logistics companies",
            startDate =("15/02/2020").stringToDate(),
            estimateTimeMonth = 7f,
            endDateActual = null,
            progress = 0f
        ),
        Project(
            name = "Telemedicine Platform",
            description = "Online medical consultation platform with video calling and prescription management",
            startDate = ("05/01/2022").stringToDate(),
            estimateTimeMonth = 9f,
            endDateActual = null,
            progress = 0f
        ),
        Project(
            name = "Event Management App",
            description = "Comprehensive event planning and ticketing platform",
            startDate = ("22/02/2025").stringToDate(),
            estimateTimeMonth = 5f,
            endDateActual = null,
            progress = 0f
        )
    )
}