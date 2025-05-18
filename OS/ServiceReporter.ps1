$ServicesName= "Spooler", "AMD Crash Defender Service", "WinRM", "BITS","EYW Bavemin"
foreach($name in $ServicesName)
{
    $service= Get-Service -ErrorAction SilentlyContinue -Name $name
    if($service)
    {
        $displayName = $service.DisplayName
        $status= $service.Status
        Write-Host -ForegroundColor Green "DisplayName= $displayName"
        Write-Host -ForegroundColor Green "Status= $status"
    }
    else
    {
        Write-Host -ForegroundColor Red "$name is Not Found!"
    }

}