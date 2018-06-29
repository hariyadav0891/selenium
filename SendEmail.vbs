Option Explicit

'Private Sub CommandButton1_Click()
'    On Error GoTo ErrHandler
    
    ' SET Outlook APPLICATION OBJECT.
    Dim objOutlook
    Set objOutlook = CreateObject("Outlook.Application")
    
    ' CREATE EMAIL OBJECT.
    Dim objEmail, olMailItem
    Set objEmail = objOutlook.CreateItem(olMailItem)

    'objEmail.CC = "prakashini.panda@boeing.com;prajna.p.shetty@boeing.com;bipin.k.jha@boeing.com;hari.s.yadav@boeing.com;Upasna.Upasna@boeing.com;santosh.singh2@boeing.com"
    objEmail.CC = "hari.s.yadav@boeing.com"
    'objEmail.To = "DL PROD OPS WINDOWS TEST CORE TEAM <DL-PRODOPSWINDOWSTESTCORETEAM@exchange.boeing.com>"
    '.BCC = "".
    objEmail.Subject = "CMES_Windows10_v1709_Automation Report"
    objEmail.Body = "Hi All" & vbCrLf & "" & vbCrLf & "PFA the automation report for CMES"& vbCrLf &""& vbCrLf & "Please provide your inputs and suggestions on this. We will make changes accordingly" & vbCrLf &""& vbCrLf & "Thanks" & vbCrLf & "Hari Shanker "
    objEmail.Attachments.Add ("C:\GIT2\BIETC_Win10_Test_Automation\CMES_Automation\Teamsid\Extend_Report\CMES_Automation_Report_Win_1709.html")
    objEmail.Send
    
    ' CLEAR.
    Set objEmail = Nothing:    Set objOutlook = Nothing
        
'ErrHandler:
    '
'End Sub
