import React, { useState, useEffect } from 'react';

const Dashboard = () => {
  const [studentData, setStudentData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Simulate loading student data
    setTimeout(() => {
      setStudentData({
        name: "Alex Johnson",
        grade: 11,
        currentGPA: 3.4,
        attendanceRate: 92,
        currentCourses: [
          { name: "Advanced Mathematics", grade: "B+", progress: 85 },
          { name: "Physics", grade: "A-", progress: 78 },
          { name: "English Literature", grade: "B", progress: 82 },
          { name: "Computer Science", grade: "A", progress: 95 }
        ],
        prerequisites: [
          { course: "Calculus", requiredGrade: "B+", currentGrade: "B+", status: "excellent" },
          { course: "Chemistry", requiredGrade: "B", currentGrade: "C+", status: "warning" },
          { course: "Algebra II", requiredGrade: "C+", currentGrade: "B", status: "good" }
        ],
        recommendations: [
          {
            course: "Advanced Physics",
            recommendation: "recommended",
            reason: "Your strong performance in Physics (A-) and excellent math skills make this a great next step!",
            prerequisites: ["Physics B+", "Calculus B+"],
            difficulty: "Medium",
            careerRelevance: "High"
          },
          {
            course: "Organic Chemistry",
            recommendation: "consider",
            reason: "Your Chemistry grade (C+) is below the recommended B. Consider improving your chemistry foundation first.",
            prerequisites: ["Chemistry B"],
            difficulty: "High",
            careerRelevance: "Medium"
          }
        ]
      });
      setLoading(false);
    }, 1000);
  }, []);

  const getStatusIcon = (status) => {
    switch (status) {
      case 'excellent': return '🌟';
      case 'good': return '✅';
      case 'warning': return '⚠️';
      case 'concern': return '❌';
      default: return '📊';
    }
  };

  const getStatusText = (status) => {
    switch (status) {
      case 'excellent': return 'Excellent';
      case 'good': return 'Good';
      case 'warning': return 'Needs Attention';
      case 'concern': return 'Concern';
      default: return 'Unknown';
    }
  };

  if (loading) {
    return (
      <div className="loading-container">
        <div className="loading-spinner"></div>
        Loading your academic journey...
      </div>
    );
  }

  return (
    <div className="dashboard">
      {/* Welcome Section */}
      <div className="welcome-section">
        <div className="welcome-icon">🎓</div>
        <h1 className="welcome-title">Welcome back, {studentData.name}!</h1>
        <p className="welcome-message">
          You're doing great in Grade {studentData.grade}! Let's explore your academic path and find the best courses for your future.
        </p>
        <div style={{ display: 'flex', gap: 'var(--spacing-4)', justifyContent: 'center', flexWrap: 'wrap' }}>
          <button className="btn btn-primary">📚 View Course Guide</button>
          <button className="btn btn-secondary">📈 Check My Progress</button>
        </div>
      </div>

      {/* Academic Overview */}
      <div className="stats-grid">
        <div className="stat-card good">
          <div className="stat-content">
            <div className="stat-icon">📊</div>
            <div className="stat-info">
              <h3>{studentData.currentGPA}</h3>
              <p>Current GPA</p>
            </div>
          </div>
        </div>

        <div className="stat-card excellent">
          <div className="stat-content">
            <div className="stat-icon">📅</div>
            <div className="stat-info">
              <h3>{studentData.attendanceRate}%</h3>
              <p>Attendance Rate</p>
            </div>
          </div>
        </div>

        <div className="stat-card good">
          <div className="stat-content">
            <div className="stat-icon">📖</div>
            <div className="stat-info">
              <h3>{studentData.currentCourses.length}</h3>
              <p>Current Courses</p>
            </div>
          </div>
        </div>

        <div className="stat-card excellent">
          <div className="stat-content">
            <div className="stat-icon">🎯</div>
            <div className="stat-info">
              <h3>{studentData.recommendations.filter(r => r.recommendation === 'recommended').length}</h3>
              <p>Recommended Courses</p>
            </div>
          </div>
        </div>
      </div>

      <div className="content-grid">
        {/* Current Courses Progress */}
        <div className="content-card">
          <h3>📚 Current Courses</h3>
          {studentData.currentCourses.map((course, index) => (
            <div key={index} className="progress-item">
              <div className="progress-header">
                <span className="progress-label">{course.name}</span>
                <span className="progress-value">{course.grade} ({course.progress}%)</span>
              </div>
              <div className="progress-bar">
                <div 
                  className={`progress-fill ${course.progress >= 90 ? 'excellent' : course.progress >= 80 ? 'good' : course.progress >= 70 ? 'warning' : 'concern'}`}
                  style={{ width: `${course.progress}%` }}
                ></div>
              </div>
            </div>
          ))}
        </div>

        {/* Prerequisites Status */}
        <div className="content-card">
          <h3>🔑 Prerequisites Check</h3>
          {studentData.prerequisites.map((prereq, index) => (
            <div key={index} style={{ 
              display: 'flex', 
              justifyContent: 'space-between', 
              alignItems: 'center', 
              padding: 'var(--spacing-3)', 
              marginBottom: 'var(--spacing-2)',
              background: 'var(--gray-50)',
              borderRadius: 'var(--radius-lg)',
              border: '1px solid var(--gray-200)'
            }}>
              <div>
                <div style={{ fontWeight: '600', color: 'var(--gray-900)' }}>{prereq.course}</div>
                <div style={{ fontSize: 'var(--font-size-sm)', color: 'var(--gray-600)' }}>
                  Required: {prereq.requiredGrade} | Your Grade: {prereq.currentGrade}
                </div>
              </div>
              <span className={`status-badge ${prereq.status}`}>
                {getStatusIcon(prereq.status)} {getStatusText(prereq.status)}
              </span>
            </div>
          ))}
        </div>
      </div>

      {/* Course Recommendations */}
      <div className="content-card" style={{ marginBottom: 'var(--spacing-8)' }}>
        <h3>🎯 Course Recommendations</h3>
        <p style={{ color: 'var(--gray-600)', marginBottom: 'var(--spacing-6)' }}>
          Based on your current performance, here are our recommendations for your next academic steps:
        </p>
        
        {studentData.recommendations.map((rec, index) => (
          <div key={index} className="course-card">
            <div className="course-header">
              <h4 className="course-title">{rec.course}</h4>
              <span className={`course-recommendation ${rec.recommendation}`}>
                {rec.recommendation === 'recommended' ? '🌟 Recommended' : 
                 rec.recommendation === 'consider' ? '🤔 Consider' : '⚠️ Not Recommended'}
              </span>
            </div>
            
            <div className="course-details">
              <div className="course-detail">
                <span className="course-detail-label">Difficulty</span>
                <span className="course-detail-value">{rec.difficulty}</span>
              </div>
              <div className="course-detail">
                <span className="course-detail-label">Career Relevance</span>
                <span className="course-detail-value">{rec.careerRelevance}</span>
              </div>
              <div className="course-detail">
                <span className="course-detail-label">Prerequisites</span>
                <span className="course-detail-value">{rec.prerequisites.join(', ')}</span>
              </div>
            </div>
            
            <div className="course-reason">
              <h4>Why this recommendation?</h4>
              <p>{rec.reason}</p>
            </div>
          </div>
        ))}
      </div>

      {/* Quick Actions */}
      <div className="content-card">
        <h3>⚡ Quick Actions</h3>
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: 'var(--spacing-4)' }}>
          <button className="btn btn-primary" style={{ width: '100%' }}>
            📋 View Full Course Catalog
          </button>
          <button className="btn btn-secondary" style={{ width: '100%' }}>
            📊 Detailed Progress Report
          </button>
          <button className="btn btn-success" style={{ width: '100%' }}>
            🎯 Set Academic Goals
          </button>
          <button className="btn btn-warning" style={{ width: '100%' }}>
            💡 Get Study Tips
          </button>
        </div>
      </div>
    </div>
  );
};

export default Dashboard; 