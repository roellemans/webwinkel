Feature: Test flow inlogpagina Webwinkel Roellemans

	Scenario: Test verkeerde inlog
		Given Ga naar de inlogpagina van Webwinkel Roellemans
		When Vul de login gegevens "abc" en "def" in
		Then Controleer de foutieve login
	
	Scenario: Test juiste inlog
		Given Ga naar de inlogpagina van Webwinkel Roellemans
		When Vul de login gegevens "Roel" en "test1234" in
		Then Controleer de juiste login
		
	Scenario: Test selecteer artikel sportschoen
		Given Ga naar de inlogpagina van Webwinkel Roellemans
		When Vul de login gegevens "Roel" en "test1234" in
		And Klik op het artikel "sportschoen"
		Then Controleer of de artikelpagina van "sportschoen" is weergegeven
