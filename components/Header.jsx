import React from 'react';

const Header = ({ onNavigate, currentPage }) => {
  return (
    <header className="header">
      <div className="header-content">
        <div className="header-brand">
          <span className="header-brand-icon">🧭</span>
          <div>
            <h1 className="header-title">PathFinder</h1>
            <div className="header-subtitle">Your Academic Journey Guide</div>
          </div>
        </div>
        
        <nav className="header-nav">
          <button
            onClick={() => onNavigate('dashboard')}
            className={`nav-button ${currentPage === 'dashboard' ? 'active' : ''}`}
          >
            🏠 My Dashboard
          </button>
          
          <button
            onClick={() => onNavigate('courses')}
            className={`nav-button ${currentPage === 'courses' ? 'active' : ''}`}
          >
            📚 Course Guide
          </button>
          
          <button
            onClick={() => onNavigate('progress')}
            className={`nav-button ${currentPage === 'progress' ? 'active' : ''}`}
          >
            📈 My Progress
          </button>
        </nav>
      </div>
    </header>
  );
};

export default Header; 