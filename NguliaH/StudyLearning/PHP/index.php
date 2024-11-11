<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Praktik nulis php</title>
</head>
<body>
<!-- Connection php  -->

<?php $conn = mysqli_connect("localhost","root","", "pendidikan") or die ("connection failed");?>

<!-- view Data -->
<h3>Lihat Data</h3>
<table broder="1">
    <tr>
        <td>NIM</td>
        <td>Nama</td>
        <td colspan="2">Action</td>
    </tr>
</table>

<?php 
    include "Koneksi.php";
    $query = mysqli_connect($conn, "selec")

    
</body>
</html>
