# --- !Ups

CREATE TABLE users (
  id VARCHAR(36) PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  email VARCHAR(200) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE student_stats (
  id VARCHAR(36) PRIMARY KEY,
  user_id VARCHAR(36) NOT NULL,
  department VARCHAR(100) NOT NULL,
  major VARCHAR(100) NOT NULL,
  gpa DOUBLE NOT NULL,
  attendance_rate DOUBLE NOT NULL,
  previous_failures INT NOT NULL,
  behavior_incidents INT NOT NULL,
  recommendations TEXT,
  CONSTRAINT fk_student_stats_user FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (id, username, email, password_hash, role, first_name, last_name, is_active) VALUES
  ('0000', 'student', 'student@example.com', '0000', 'Student', 'Student', 'User', TRUE),
  ('1000', 'alice', 'alice@example.com', 'alice123', 'Student', 'Alice', 'Tan', TRUE),
  ('2000', 'bob', 'bob@example.com', 'bob123', 'Student', 'Bob', 'Lim', TRUE);

INSERT INTO student_stats (id, user_id, department, major, gpa, attendance_rate, previous_failures, behavior_incidents, recommendations) VALUES
  ('s-0000', '0000', 'School of Computing', 'Computer Science', 3.50, 0.95, 0, 0, 'Keep up the good work.'),
  ('s-1000', '1000', 'School of Computing', 'Computer Science', 3.20, 0.90, 1, 1, 'Focus on algorithms and data structures.'),
  ('s-2000', '2000', 'School of Computing', 'Computer Science', 3.00, 0.88, 2, 0, 'Attend coding labs regularly.');

# --- !Downs

DROP TABLE student_stats;
DROP TABLE users;


