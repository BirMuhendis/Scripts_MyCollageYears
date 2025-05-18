Write-Host "Please Choose the Option!"
Write-Host "Adder-1"
Write-Host "Subst-2"
Write-Host "Multip-3"
Write-Host "Divid-4"
Write-Host "Exit-5" 
$key=Read-Host "Input"
if($key -eq 1)
{
    $a=Read-Host "Please Enter the Value a"
    $b=Read-Host "Please Enter the Value b"
    $c= [double] $a + [double] $b
    
}
elseif($key -eq 2)
{
    $a=Read-Host "Please Enter the Value a"
    $b=Read-Host "Please Enter the Value b"
    $c= [double] $a - [double] $b
}
elseif($key -eq 3)
{
    $a=Read-Host "Please Enter the Value a"
    $b=Read-Host "Please Enter the Value b"
    $c= [double] $a * [double] $b
}
elseif($key -eq 4)
{
    $a=Read-Host "Please Enter the Value a"
    $b=Read-Host "Please Enter the Value b"
    $c= [double] $a / [double] $b
}
else
{
    exit
}  
Write-Host "Result : $c"