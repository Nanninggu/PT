CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
    timestamp VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL
);