$operationKey= Read-Host "Choose for Operation Type <F>ile or P<Process>"
if($operationKey -eq "F")
{
    $filePath = Read-Host "Please Enter The Full-File Path"
    $Checker =Test-Path -PathType Leaf $filePath 
    if($Checker) {Write-Host -ForegroundColor Green "There is a File in that path."}
    else{Write-Host -ForegroundColor Red "There is not a File in that path."}

}
elseif($operationKey -eq "P")
{
    $processName= Read-Host "Please Enter Just a Process of Name" 
    $process= Get-Process -ErrorAction SilentlyContinue -Name $processName
    if($process){Write-Host -ForegroundColor Green "There is a Process with that name."}
    else{Write-Host -ForegroundColor Red "There is not a Process with that name."}
    
}
else
{
    Write-Host -ForegroundColor Yellow "Invalid Choose!" 
} 