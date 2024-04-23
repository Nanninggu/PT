import psycopg2

# Define your PostgreSQL connection parameters
db_params = {
    "host": "localhost",
    "database": "hexagonal-architecture",
    "user": "postgres",
    "password": "test1234"
}

# Connect to your postgres DB
conn = psycopg2.connect(**db_params)

# Open a cursor to perform database operations
cur = conn.cursor()

# Path to the CSV file
file_path = r"C:\Users\김승현\Desktop\open data set\heart_attack_prediction_dataset.csv"

# Open the CSV file
with open(file_path, 'r') as f:
    # Skip the header
    next(f)
    # Copy the data from the file to the table
    cur.copy_from(f, 'csv_table', sep=',')

# Close communication with the PostgreSQL database server
cur.close()

# Commit the changes
conn.commit()

# Close the connection
conn.close()