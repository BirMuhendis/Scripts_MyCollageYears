function FindLargeFiles
{
    param(
        [string]$SearchPath = "C:\Windows\System32",
        [int]$MinSizeMB = 5,
        [string]$LogFilePath = "C:\Users\Goktug\Desktop\OS\Log.txt"
    )

    $MinSizeBytes = $MinSizeMB * 1024*1024

    "FullName`tLastWriteTime`tSizeMB" | Out-File -FilePath $LogFilePath -Force

    Get-ChildItem -Path $SearchPath -Recurse -File -ErrorAction SilentlyContinue |
        Where-Object { $_.Length -gt $MinSizeBytes } |
        Select-Object FullName, LastWriteTime, @{Name='SizeMB'; Expression = { [int]($_.Length / 1024*1024) }} |
        ForEach-Object {
            $logEntry = "{0}`t{1}`t{2}" -f $_.FullName, $_.LastWriteTime, $_.SizeMB
            Write-Host $logEntry
            Add-Content -Path $LogFilePath -Value $logEntry
            Start-Process -FilePath $LogFilePath
        }
}
