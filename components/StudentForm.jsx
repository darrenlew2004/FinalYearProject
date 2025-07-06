import React, { useState, useEffect } from 'react';

const StudentForm = ({ student, onSubmit, onCancel, isLoading = false }) => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    grade: 9,
    age: 14,
    attendanceRate: 90,
    gpa: 3.0,
    behaviorIncidents: 0,
    socioeconomicStatus: 'medium',
    familySupport: 'medium',
    previousFailures: 0,
    studyTime: 10,
    internetAccess: true,
    healthIssues: [],
    extracurricularActivities: []
  });

  const [newHealthIssue, setNewHealthIssue] = useState('');
  const [newActivity, setNewActivity] = useState('');

  useEffect(() => {
    if (student) {
      setFormData(student);
    }
  }, [student]);

  const handleInputChange = (field, value) => {
    setFormData(prev => ({
      ...prev,
      [field]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  const addHealthIssue = () => {
    if (newHealthIssue.trim() && !formData.healthIssues.includes(newHealthIssue.trim())) {
      handleInputChange('healthIssues', [...formData.healthIssues, newHealthIssue.trim()]);
      setNewHealthIssue('');
    }
  };

  const removeHealthIssue = (issue) => {
    handleInputChange('healthIssues', formData.healthIssues.filter(h => h !== issue));
  };

  const addActivity = () => {
    if (newActivity.trim() && !formData.extracurricularActivities.includes(newActivity.trim())) {
      handleInputChange('extracurricularActivities', [...formData.extracurricularActivities, newActivity.trim()]);
      setNewActivity('');
    }
  };

  const removeActivity = (activity) => {
    handleInputChange('extracurricularActivities', formData.extracurricularActivities.filter(a => a !== activity));
  };

  return (
    <div className="content-card" style={{ maxWidth: '800px', margin: '0 auto' }}>
      <div className="dashboard-header">
        <h1 className="dashboard-title">
          {student ? '✏️ Edit Student' : '➕ Add New Student'}
        </h1>
        <p className="dashboard-subtitle">
          {student ? 'Update student information and risk factors' : 'Enter student information and risk factors'}
        </p>
      </div>
      
      <form onSubmit={handleSubmit}>
        {/* Basic Information */}
        <div className="content-card" style={{ marginBottom: 'var(--spacing-6)' }}>
          <h3 style={{ marginBottom: 'var(--spacing-4)' }}>👤 Basic Information</h3>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 'var(--spacing-4)' }}>
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                First Name *
              </label>
              <input
                type="text"
                value={formData.firstName}
                onChange={(e) => handleInputChange('firstName', e.target.value)}
                required
                placeholder="Enter first name"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Last Name *
              </label>
              <input
                type="text"
                value={formData.lastName}
                onChange={(e) => handleInputChange('lastName', e.target.value)}
                required
                placeholder="Enter last name"
              />
            </div>
            
            <div style={{ gridColumn: '1 / -1' }}>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Email *
              </label>
              <input
                type="email"
                value={formData.email}
                onChange={(e) => handleInputChange('email', e.target.value)}
                required
                placeholder="Enter email address"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Grade *
              </label>
              <select
                value={formData.grade}
                onChange={(e) => handleInputChange('grade', parseInt(e.target.value))}
              >
                <option value={9}>9th Grade</option>
                <option value={10}>10th Grade</option>
                <option value={11}>11th Grade</option>
                <option value={12}>12th Grade</option>
              </select>
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Age *
              </label>
              <input
                type="number"
                value={formData.age}
                onChange={(e) => handleInputChange('age', parseInt(e.target.value))}
                min="13"
                max="19"
                required
                placeholder="Enter age"
              />
            </div>
          </div>
        </div>

        {/* Academic Information */}
        <div className="content-card" style={{ marginBottom: 'var(--spacing-6)' }}>
          <h3 style={{ marginBottom: 'var(--spacing-4)' }}>📚 Academic Information</h3>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 'var(--spacing-4)' }}>
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Attendance Rate (%) *
              </label>
              <input
                type="number"
                value={formData.attendanceRate}
                onChange={(e) => handleInputChange('attendanceRate', parseFloat(e.target.value))}
                min="0"
                max="100"
                step="0.1"
                required
                placeholder="Enter attendance rate"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                GPA *
              </label>
              <input
                type="number"
                value={formData.gpa}
                onChange={(e) => handleInputChange('gpa', parseFloat(e.target.value))}
                min="0"
                max="4"
                step="0.1"
                required
                placeholder="Enter GPA"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Behavior Incidents
              </label>
              <input
                type="number"
                value={formData.behaviorIncidents}
                onChange={(e) => handleInputChange('behaviorIncidents', parseInt(e.target.value))}
                min="0"
                placeholder="Number of incidents"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Previous Failures
              </label>
              <input
                type="number"
                value={formData.previousFailures}
                onChange={(e) => handleInputChange('previousFailures', parseInt(e.target.value))}
                min="0"
                placeholder="Number of failures"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Study Time (hours/week)
              </label>
              <input
                type="number"
                value={formData.studyTime}
                onChange={(e) => handleInputChange('studyTime', parseInt(e.target.value))}
                min="0"
                max="40"
                placeholder="Hours per week"
              />
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Internet Access
              </label>
              <div style={{ display: 'flex', alignItems: 'center', height: '100%' }}>
                <input
                  type="checkbox"
                  checked={formData.internetAccess}
                  onChange={(e) => handleInputChange('internetAccess', e.target.checked)}
                  style={{ marginRight: 'var(--spacing-2)', transform: 'scale(1.2)' }}
                />
                <span>Available at home</span>
              </div>
            </div>
          </div>
        </div>

        {/* Background Information */}
        <div className="content-card" style={{ marginBottom: 'var(--spacing-6)' }}>
          <h3 style={{ marginBottom: 'var(--spacing-4)' }}>🏠 Background Information</h3>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 'var(--spacing-4)' }}>
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Socioeconomic Status
              </label>
              <select
                value={formData.socioeconomicStatus}
                onChange={(e) => handleInputChange('socioeconomicStatus', e.target.value)}
              >
                <option value="low">Low</option>
                <option value="medium">Medium</option>
                <option value="high">High</option>
              </select>
            </div>
            
            <div>
              <label style={{ display: 'block', marginBottom: 'var(--spacing-2)', fontWeight: '500', color: 'var(--gray-700)' }}>
                Family Support
              </label>
              <select
                value={formData.familySupport}
                onChange={(e) => handleInputChange('familySupport', e.target.value)}
              >
                <option value="low">Low</option>
                <option value="medium">Medium</option>
                <option value="high">High</option>
              </select>
            </div>
          </div>
        </div>
        
        {/* Health Issues */}
        <div className="content-card" style={{ marginBottom: 'var(--spacing-6)' }}>
          <h3 style={{ marginBottom: 'var(--spacing-4)' }}>🏥 Health Issues</h3>
          <div style={{ display: 'flex', gap: 'var(--spacing-3)', marginBottom: 'var(--spacing-4)' }}>
            <input
              type="text"
              placeholder="Add health issue"
              value={newHealthIssue}
              onChange={(e) => setNewHealthIssue(e.target.value)}
              onKeyPress={(e) => e.key === 'Enter' && addHealthIssue()}
              style={{ flex: 1 }}
            />
            <button type="button" onClick={addHealthIssue} className="btn btn-secondary">
              Add
            </button>
          </div>
          <div style={{ display: 'flex', flexWrap: 'wrap', gap: 'var(--spacing-2)' }}>
            {formData.healthIssues.map((issue, index) => (
              <span
                key={index}
                className="risk-badge"
                style={{
                  backgroundColor: '#fef2f2',
                  color: 'var(--danger-color)',
                  display: 'flex',
                  alignItems: 'center',
                  gap: 'var(--spacing-2)'
                }}
              >
                {issue}
                <button
                  type="button"
                  onClick={() => removeHealthIssue(issue)}
                  style={{
                    background: 'none',
                    border: 'none',
                    cursor: 'pointer',
                    fontSize: 'var(--font-size-lg)',
                    color: 'inherit',
                    padding: 0,
                    margin: 0
                  }}
                >
                  ×
                </button>
              </span>
            ))}
          </div>
        </div>
        
        {/* Extracurricular Activities */}
        <div className="content-card" style={{ marginBottom: 'var(--spacing-6)' }}>
          <h3 style={{ marginBottom: 'var(--spacing-4)' }}>🎯 Extracurricular Activities</h3>
          <div style={{ display: 'flex', gap: 'var(--spacing-3)', marginBottom: 'var(--spacing-4)' }}>
            <input
              type="text"
              placeholder="Add activity"
              value={newActivity}
              onChange={(e) => setNewActivity(e.target.value)}
              onKeyPress={(e) => e.key === 'Enter' && addActivity()}
              style={{ flex: 1 }}
            />
            <button type="button" onClick={addActivity} className="btn btn-secondary">
              Add
            </button>
          </div>
          <div style={{ display: 'flex', flexWrap: 'wrap', gap: 'var(--spacing-2)' }}>
            {formData.extracurricularActivities.map((activity, index) => (
              <span
                key={index}
                className="risk-badge"
                style={{
                  backgroundColor: '#f0fdf4',
                  color: 'var(--success-color)',
                  display: 'flex',
                  alignItems: 'center',
                  gap: 'var(--spacing-2)'
                }}
              >
                {activity}
                <button
                  type="button"
                  onClick={() => removeActivity(activity)}
                  style={{
                    background: 'none',
                    border: 'none',
                    cursor: 'pointer',
                    fontSize: 'var(--font-size-lg)',
                    color: 'inherit',
                    padding: 0,
                    margin: 0
                  }}
                >
                  ×
                </button>
              </span>
            ))}
          </div>
        </div>
        
        <div style={{ display: 'flex', gap: 'var(--spacing-4)', justifyContent: 'center' }}>
          <button
            type="submit"
            disabled={isLoading}
            className="btn btn-primary"
            style={{ minWidth: '120px' }}
          >
            {isLoading ? '💾 Saving...' : (student ? '✏️ Update' : '💾 Save')}
          </button>
          <button
            type="button"
            onClick={onCancel}
            disabled={isLoading}
            className="btn btn-secondary"
            style={{ minWidth: '120px' }}
          >
            ❌ Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default StudentForm; 