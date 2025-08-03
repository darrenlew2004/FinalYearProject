package models

import play.api.libs.json._
import java.time.LocalDateTime

// Enums
sealed trait RiskLevel
case object Low extends RiskLevel
case object Medium extends RiskLevel
case object High extends RiskLevel

sealed trait UserRole
case object Admin extends UserRole
case object Teacher extends UserRole
case object Student extends UserRole

// Data Models
case class Student(
  id: String,
  name: String,
  email: String,
  age: Int,
  grade: String,
  gpa: Double,
  attendanceRate: Double,
  previousFailures: Int,
  behaviorIncidents: Int,
  socioeconomicStatus: String,
  familySupport: Boolean,
  studyTime: Int,
  internetAccess: Boolean,
  healthIssues: String,
  extracurricularActivities: List[String],
  createdAt: LocalDateTime,
  updatedAt: LocalDateTime
)

case class Course(
  id: String,
  name: String,
  code: String,
  credits: Int,
  instructor: String,
  department: String,
  difficulty: String,
  prerequisites: List[String],
  maxStudents: Int,
  currentEnrollment: Int,
  createdAt: LocalDateTime,
  updatedAt: LocalDateTime
)

case class RiskPrediction(
  id: String,
  studentId: String,
  courseId: String,
  riskLevel: RiskLevel,
  confidenceScore: Double,
  contributingFactors: List[String],
  predictedGrade: String,
  recommendations: List[String],
  createdAt: LocalDateTime
)

case class StudentPerformance(
  id: String,
  studentId: String,
  courseId: String,
  grade: String,
  attendance: Double,
  assignments: Int,
  completedAssignments: Int,
  examScores: List[Double],
  semester: String,
  year: Int,
  createdAt: LocalDateTime
)

case class CourseAnalytics(
  id: String,
  courseId: String,
  totalStudents: Int,
  averageGrade: Double,
  passRate: Double,
  riskDistribution: Map[RiskLevel, Int],
  topRiskFactors: List[String],
  semester: String,
  year: Int,
  createdAt: LocalDateTime
)

case class AnalyticsTrends(
  period: String,
  totalStudents: Int,
  averageRiskScore: Double,
  riskDistribution: Map[RiskLevel, Int],
  topCourses: List[String],
  topRiskFactors: List[String],
  interventionSuccessRate: Double
)

case class ModelExplanation(
  id: String,
  predictionId: String,
  featureImportance: Map[String, Double],
  shapValues: Map[String, Double],
  localExplanation: String,
  globalExplanation: String,
  confidenceIntervals: Map[String, (Double, Double)]
)

case class AuditLog(
  id: String,
  userId: String,
  action: String,
  resource: String,
  resourceId: String,
  details: String,
  ipAddress: String,
  userAgent: String,
  timestamp: LocalDateTime
)

case class User(
  id: String,
  username: String,
  email: String,
  role: UserRole,
  firstName: String,
  lastName: String,
  isActive: Boolean,
  lastLogin: Option[LocalDateTime],
  createdAt: LocalDateTime,
  updatedAt: LocalDateTime
)

// Request/Response Models
case class LoginRequest(
  username: String,
  password: String
)

case class RegisterRequest(
  username: String,
  email: String,
  password: String,
  firstName: String,
  lastName: String,
  role: UserRole
)

case class AuthResponse(
  token: String,
  refreshToken: String,
  user: User,
  expiresIn: Long
)

case class ApiResponse[T](
  success: Boolean,
  data: Option[T],
  message: String,
  error: Option[String] = None
)

case class PaginatedResponse[T](
  data: List[T],
  total: Int,
  page: Int,
  pageSize: Int,
  totalPages: Int
)

// JSON Format Instances
object JsonFormats {
  import play.api.libs.json._

  // Enum formats
  implicit val riskLevelFormat: Format[RiskLevel] = Format(
    Reads {
      case JsString("Low") => JsSuccess(Low)
      case JsString("Medium") => JsSuccess(Medium)
      case JsString("High") => JsSuccess(High)
      case _ => JsError("Invalid risk level")
    },
    Writes {
      case Low => JsString("Low")
      case Medium => JsString("Medium")
      case High => JsString("High")
    }
  )

  implicit val userRoleFormat: Format[UserRole] = Format(
    Reads {
      case JsString("Admin") => JsSuccess(Admin)
      case JsString("Teacher") => JsSuccess(Teacher)
      case JsString("Student") => JsSuccess(Student)
      case _ => JsError("Invalid user role")
    },
    Writes {
      case Admin => JsString("Admin")
      case Teacher => JsString("Teacher")
      case Student => JsString("Student")
    }
  )

  // DateTime format
  implicit val localDateTimeFormat: Format[LocalDateTime] = Format(
    Reads(_.validate[String].map(LocalDateTime.parse)),
    Writes(date => JsString(date.toString))
  )

  // Model formats
  implicit val studentFormat: Format[Student] = Json.format[Student]
  implicit val courseFormat: Format[Course] = Json.format[Course]
  implicit val riskPredictionFormat: Format[RiskPrediction] = Json.format[RiskPrediction]
  implicit val studentPerformanceFormat: Format[StudentPerformance] = Json.format[StudentPerformance]
  implicit val courseAnalyticsFormat: Format[CourseAnalytics] = Json.format[CourseAnalytics]
  implicit val analyticsTrendsFormat: Format[AnalyticsTrends] = Json.format[AnalyticsTrends]
  implicit val modelExplanationFormat: Format[ModelExplanation] = Json.format[ModelExplanation]
  implicit val auditLogFormat: Format[AuditLog] = Json.format[AuditLog]
  implicit val userFormat: Format[User] = Json.format[User]
  implicit val loginRequestFormat: Format[LoginRequest] = Json.format[LoginRequest]
  implicit val registerRequestFormat: Format[RegisterRequest] = Json.format[RegisterRequest]
  implicit val authResponseFormat: Format[AuthResponse] = Json.format[AuthResponse]
  implicit val apiResponseFormat: Format[ApiResponse] = Json.format[ApiResponse]
  implicit val paginatedResponseFormat: Format[PaginatedResponse] = Json.format[PaginatedResponse]
} 