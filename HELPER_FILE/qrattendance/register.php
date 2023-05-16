<?php
include 'connection.php';

$fullname = $_POST['fullname'];
$username = $_POST['username'];
$email = $_POST['email'];
$password = $_POST['password'];

$insert_query = "INSERT INTO users (fullname, username, email, password) VALUES (?, ?, ?, ?)";

if ($stmt = mysqli_prepare($conn, $insert_query)) {
    // Bind variables to the prepared statement as parameters
    mysqli_stmt_bind_param($stmt, "ssss", $fullname, $username, $email, $password);

    // Attempt to execute the prepared statement
    if (mysqli_stmt_execute($stmt)) {
        echo "Success";
    } else {
        echo "Error: " . mysqli_error($conn);
    }

    // Close statement
    mysqli_stmt_close($stmt);
} else {
    echo "Error: " . mysqli_error($conn);
}

// Close connection
mysqli_close($conn);
?>
