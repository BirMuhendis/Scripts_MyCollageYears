#Hi!
$currentDate= Get-Date
$userName= $env:USERNAME
$compInfo = Get-ComputerInfo
$CurrentOS = $compInfo.OsName + " " + $compInfo.OsVersion


Write-Host "Hi!"
Write-Host "User-Name= $userName"
Write-Host "Date = $currentDate"
Write-Host "Current OS= $CurrentOS"