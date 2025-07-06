# Student Risk Prediction System - Frontend

A React-based frontend application for managing student data and performing risk assessments to identify students who may be at risk of academic failure.

## Features

- **Dashboard**: Overview of student statistics and risk assessments
- **Student Management**: Add, edit, and manage student information
- **Risk Assessment**: Perform and view risk assessments for students
- **Analytics**: View trends and statistics

## Project Structure

```
src/
├── components/          # Reusable UI components
│   ├── Header.tsx      # Navigation header
│   └── StudentForm.tsx # Student input form
├── pages/              # Main application pages
│   └── Dashboard.tsx   # Dashboard page
├── services/           # API services
│   └── api.ts         # API client for backend communication
├── types/              # TypeScript type definitions
│   └── index.ts       # Data models and interfaces
├── utils/              # Utility functions
├── hooks/              # Custom React hooks
└── App.jsx            # Main application component
```

## Getting Started

### Prerequisites

- Node.js (v14 or higher)
- npm or yarn

### Installation

1. Install dependencies:
```bash
npm install @mui/material @emotion/react @emotion/styled @mui/icons-material axios recharts react-router-dom
```

2. Start the development server:
```bash
npm run dev
```

3. Open your browser and navigate to `http://localhost:5173`

## Backend Integration

This frontend is designed to work with a Scala backend that provides the following API endpoints:

- `GET /api/students` - Get all students
- `POST /api/students` - Create a new student
- `PUT /api/students/{id}` - Update a student
- `DELETE /api/students/{id}` - Delete a student
- `POST /api/risk-assessment/{studentId}` - Perform risk assessment
- `GET /api/risk-assessment` - Get all risk assessments
- `GET /api/analytics/risk-statistics` - Get risk statistics

## Student Data Model

The application collects comprehensive student information including:

- Personal information (name, email, age, grade)
- Academic performance (GPA, attendance rate, previous failures)
- Behavioral data (behavior incidents)
- Environmental factors (socioeconomic status, family support)
- Study habits (study time, internet access)
- Health and activities (health issues, extracurricular activities)

## Risk Assessment

The system evaluates students based on multiple factors to determine their risk level:

- **Low Risk**: Students with good academic performance and support systems
- **Medium Risk**: Students with some concerning factors but manageable risks
- **High Risk**: Students requiring immediate intervention and support

## Technologies Used

- **React 18** - Frontend framework
- **Material-UI** - UI component library
- **TypeScript** - Type safety and better development experience
- **Vite** - Build tool and development server
- **Axios** - HTTP client for API calls

## Development

### Adding New Features

1. Create new components in the `components/` directory
2. Add new pages in the `pages/` directory
3. Update the API service layer in `services/api.ts`
4. Add new types in `types/index.ts`

### Styling

The application uses Material-UI for consistent styling. Custom styles can be added using the `sx` prop or by creating custom theme overrides.

## Contributing

1. Follow the existing code structure and patterns
2. Use TypeScript for type safety
3. Test your changes thoroughly
4. Update documentation as needed

## License

This project is part of a student risk prediction system designed for educational institutions. 