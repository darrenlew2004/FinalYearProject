import React, { useState } from 'react';
import Header from './components/Header';
import Dashboard from './pages/Dashboard';
import './App.css';

function App() {
  const [currentPage, setCurrentPage] = useState('dashboard');

  const handleNavigate = (page) => {
    setCurrentPage(page);
  };

  const renderContent = () => {
    switch (currentPage) {
      case 'dashboard':
        return <Dashboard />;
      case 'courses':
        return (
          <div className="container">
            <div className="content-card">
              <div className="dashboard-header">
                <h1 className="dashboard-title">📚 Course Guide</h1>
                <p className="dashboard-subtitle">Explore available courses and find your perfect academic path</p>
              </div>
              <div style={{ textAlign: 'center', padding: 'var(--spacing-8)', color: 'var(--gray-600)' }}>
                <div style={{ fontSize: 'var(--font-size-4xl)', marginBottom: 'var(--spacing-4)' }}>🔍</div>
                <h3 style={{ marginBottom: 'var(--spacing-2)' }}>Course Catalog</h3>
                <p>Browse through all available courses, check prerequisites, and get personalized recommendations based on your academic profile.</p>
                <div style={{ display: 'flex', gap: 'var(--spacing-4)', justifyContent: 'center', marginTop: 'var(--spacing-6)', flexWrap: 'wrap' }}>
                  <button className="btn btn-primary">🔍 Search Courses</button>
                  <button className="btn btn-secondary">📋 View All Courses</button>
                  <button className="btn btn-success">🎯 Get Recommendations</button>
                </div>
              </div>
            </div>
          </div>
        );
      case 'progress':
        return (
          <div className="container">
            <div className="content-card">
              <div className="dashboard-header">
                <h1 className="dashboard-title">📈 My Progress</h1>
                <p className="dashboard-subtitle">Track your academic journey and celebrate your achievements</p>
              </div>
              <div style={{ textAlign: 'center', padding: 'var(--spacing-8)', color: 'var(--gray-600)' }}>
                <div style={{ fontSize: 'var(--font-size-4xl)', marginBottom: 'var(--spacing-4)' }}>📊</div>
                <h3 style={{ marginBottom: 'var(--spacing-2)' }}>Academic Progress</h3>
                <p>Monitor your grades, attendance, and overall academic performance. Set goals and track your improvement over time.</p>
                <div style={{ display: 'flex', gap: 'var(--spacing-4)', justifyContent: 'center', marginTop: 'var(--spacing-6)', flexWrap: 'wrap' }}>
                  <button className="btn btn-primary">📊 View Detailed Report</button>
                  <button className="btn btn-secondary">📅 Attendance History</button>
                  <button className="btn btn-success">🎯 Set Goals</button>
                </div>
              </div>
            </div>
          </div>
        );
      default:
        return <Dashboard />;
    }
  };

  return (
    <div className="App">
      <Header onNavigate={handleNavigate} currentPage={currentPage} />
      <main>
        {renderContent()}
      </main>
    </div>
  );
}

export default App; 