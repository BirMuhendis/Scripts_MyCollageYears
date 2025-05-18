function List-Files 
{
    param(
        [String]$DirectoryPath,
        [String]$Filter #(*.ini , *.exe ...)
    )
        if(Test-Path -PathType Container $DirectoryPath )
        {
            Write-Host -ForegroundColor Yellow "DirectoryPath: $DirectoryPath"
            Write-Host -ForegroundColor Yellow "Filter: $Filter"    
            Get-ChildItem -Path $DirectoryPath -Filter $Filter -File | Select-Object Name, Length, LastWriteTime
        }
        else
        {
            Write-Warning
        }
}