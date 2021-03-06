// Premiers.Secours.3.0.standard
package de.firstai;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import de.enough.polish.ui.UiAccess;


public class FirstAid3 extends MIDlet implements CommandListener {

	boolean started = false;
	Form details;
	Display display;
	List menu;
	List telEmergency;

	// setup of the navigation buttons
	static final Command cmdBack = new Command("Retour", Command.BACK, 2);
	static final Command cmdExit = new Command("Quitter", Command.EXIT, 2);

	StringItem aid_disclaimer, aid_general, aid_allergic, aid_asthma, aid_amputation, aid_apnoea, aid_checkbreathing, aid_eyeinjury, aid_chemicalburneyes, 
	aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_bleedinglight, aid_bleedingsevere, aid_diabeticcoma, aid_diarrhoea, aid_icerescue, aid_electricityaccident, aid_epilepsy, 
	aid_vomiting, aid_frostbitemild, aid_frostbitesevere, aid_suffocation, aid_drowning, aid_birth, aid_dangerzone, aid_brainconcussion, aid_resuscitation, aid_heartattack, aid_hyperthermia, 
	aid_insectstings, aid_fracture, aid_nosebleeding, aid_emergencycall, aid_backinjury, aid_skullfracture, aid_stroke, aid_snakebite, aid_shock, aid_sunburn, aid_sunstroke, 
	aid_sos, aid_recoveryposition, aid_animalbite, aid_safeguardaccident, aid_hypothermia, aid_hypoglycaemia, aid_chemicalburn, aid_burningslight, aid_burningsevere, aid_poisining, 
	aid_sprain, separator;

	StringItem[] stringItemArray;
	Image aid001, aid003, aid008, aid009, aid010, aid011, aid012, aid013, aid019, aid022;
	Image aid023, aid025, aid028, aid029, aid030, aid031, aid034, aid041, aid045, aid058;
	Image aid061, aid065, aid067, aid069, aid084, aid085, aid089, aid092, aid107;
	Image imageCC;

	StringItem stringAfrica;
	StringItem stringAsia;
	StringItem stringEurope;
	StringItem stringNorthamerica;
	StringItem stringOceania;
	StringItem stringSouthamerica;
	
	public FirstAid3() {

		this.menu = new List("Premiers Secours 3.0", Choice.IMPLICIT);
		this.menu.append("# Responsabilit� + Info", null);
		this.menu.append("# Appels d'urgence", null);
		this.menu.append("# Conduite g�n�rale", null);
		this.menu.append("Allergie", null);
		this.menu.append("Accident de la circulation", null);
		// this.menu.append("Accident de voiture", null);
		this.menu.append("Accouchement", null);
		this.menu.append("Amputation", null);
		this.menu.append("Appelez les services d'urgence", null);
		this.menu.append("Arr�t respiratoire", null);
		this.menu.append("Asthme", null);
		this.menu.append("Br�lure chimique", null);
		this.menu.append("Br�lure chimique (yeux)", null);
		this.menu.append("Br�lure grave", null);
		this.menu.append("Br�lure l�g�re", null);
		this.menu.append("Br�lure par le froid - grave", null);
		this.menu.append("Br�lure par le froid - l�ger", null);
		this.menu.append("Choc (H�morragies)", null);
		this.menu.append("Coma diab�tique", null);
		this.menu.append("Commotion c�r�brale", null);
		this.menu.append("Compression du thorax", null);
		this.menu.append("Coup de soleil", null);
		this.menu.append("Crise Cardiaque", null);
		this.menu.append("D�gagement d'urgence", null);
		this.menu.append("Diarrh�es", null);
		this.menu.append("Dos - Blessure", null);
		this.menu.append("�lectrocution", null);
		this.menu.append("Entorse", null);
		this.menu.append("�pilepsie", null);
		this.menu.append("Essoufflement", null);
		this.menu.append("Etouffement/�tranglement", null);
		// this.menu.append("�tranglement", null);
		this.menu.append("Fracture", null);
		this.menu.append("Fracture du cr�ne", null);
		this.menu.append("Fracture du dos", null);
		this.menu.append("Hyperglyc�mie (forte teneur en sucre)", null);
		this.menu.append("Hyperthermie (corps trop chaud)", null);
		this.menu.append("Hypoglyc�mie (faible teneur en sucre)", null);
		this.menu.append("Hypothermie (corps trop froid)", null);
		this.menu.append("Inconscient avec respiration", null);
		this.menu.append("Inconscient sans respiration", null);
		this.menu.append("Insolation", null);
		this.menu.append("Intoxication", null);
		this.menu.append("Morsures d'animaux", null);
		this.menu.append("Nez - saignement", null);
		this.menu.append("Noyade", null);
		this.menu.append("Oeil - blessures", null);
		this.menu.append("Piq�res d'insectes", null);
		this.menu.append("Position lat�rale de s�curit�", null);
		this.menu.append("R�animation", null);
		// this.menu.append("R�animation", null);
		this.menu.append("Respiration", null);
		this.menu.append("Saignement grave", null);
		this.menu.append("Saignement l�ger", null);
		this.menu.append("Sauvetage sur glace", null);
		this.menu.append("Serpent - Morsures", null);
		this.menu.append("SOS", null);
		this.menu.append("V�rifiez la respiration", null);
		this.menu.append("Vertige", null);
		this.menu.append("Vomissements", null);
		this.menu.append("-------------", null); //
		this.menu.append("Appelez 112", null); //

		// commands
		this.menu.addCommand(cmdExit);
		this.menu.setCommandListener(this);

		details = new Form ("First Aid on your Mobile");

		/**** Init the Images ****/
		try { aid001 = Image.createImage ("/aid001.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid003 = Image.createImage ("/aid003.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid008 = Image.createImage ("/aid008.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid009 = Image.createImage ("/aid009.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid010 = Image.createImage ("/aid010.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid011 = Image.createImage ("/aid011.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid012 = Image.createImage ("/aid012.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid013 = Image.createImage ("/aid013.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid019 = Image.createImage ("/aid019.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid022 = Image.createImage ("/aid022.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }

		try { aid023 = Image.createImage ("/aid023.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid025 = Image.createImage ("/aid025.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid028 = Image.createImage ("/aid028.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid029 = Image.createImage ("/aid029.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid030 = Image.createImage ("/aid030.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid031 = Image.createImage ("/aid031.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid034 = Image.createImage ("/aid034.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid041 = Image.createImage ("/aid041.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid045 = Image.createImage ("/aid045plug.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid058 = Image.createImage ("/aid058.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }

		try { aid061 = Image.createImage ("/aid061.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid065 = Image.createImage ("/aid065.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid067 = Image.createImage ("/aid067.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid069 = Image.createImage ("/aid069.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid084 = Image.createImage ("/aid084.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid085 = Image.createImage ("/aid085.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid089 = Image.createImage ("/aid089.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid092 = Image.createImage ("/aid092.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid107 = Image.createImage ("/aid107.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		
		try { imageCC = Image.createImage ("/cc88x31.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
	}

	public void startApp() {
		if (!started) {
			// emergency numbers list
			telEmergency = new List ("Continent", Choice.IMPLICIT);
			telEmergency.append("Afrique", null);
			telEmergency.append("Am�rique du Nord / Centrale", null);
			telEmergency.append("Am�rique du Sud", null);
			telEmergency.append("Asie", null);
			telEmergency.append("Europe", null);
			telEmergency.append("Oc�anie", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			stringAfrica = new StringItem("- Afrique -", "\n# Afrique du Sud\nPol:10111 | Amb:10177 | Pom:10111\n\n# Alg�rie\nPol:17 | Amb:17 | Pom:14\n\n# Angola\nPol:110 | Amb:118 | Pom:118\n\n# B�nin\nPol:17 | Amb:301769 | Pom:18\n\n# Botswana\nPol:999 | Amb:997 | Pom:998\n\n# Burkina Faso\nPol:17 | Amb:Num�ro Local | Pom:18\n\n# Burundi\nPol:Pas de syst�me | Amb:Pas de syst�me | Pom:Pas de syst�me\n\n# Cameroun\nPol:17 | Amb:Num�ro Local | Pom:18\n\n# Cap-Vert\nPol:132 | Amb:130 | Pom:131\n\n# Comores\nPol:Radio t�l�phone seulement | Amb:Radio t�l�phone seulement | Pom:Radio t�l�phone seulement\n\n# Congo (R�publique d�mocratique)\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Congo (R�publique)\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# C�te d'Ivoire\nPol:110 | Amb:110 | Pom:180\n\n# Djibouti\nPol:17 | Amb:351351 | Pom:18\n\n# Egypte\nPol:122 | Amb:123 | Pom:180\n\n# Erythr�e\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Ethiopie\nPol:91 | Amb:92 | Pom:93\n\n# Gabon\nPol:1730 | Amb:1300 | Pom:18\n\n# Gambie\nPol:117 | Amb:116 | Pom:118\n\n# Ghana\nPol:191 | Amb:193 | Pom:192\n\n# Guin�e\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Guin�e �quatoriale\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Guin�e-Bissau\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Kenya\nPol:999 | Amb:999 | Pom:999\n\n# Lesotho\nPol:123 | Amb:121 | Pom:122\n\n# Lib�ria\nPol:911 | Amb:911 | Pom:911\n\n# Libye\nPol:193 | Amb:193 | Pom:193\n\n# Madagascar\nPol:117 | Amb:2262566 | Pom:18\n\n# Malawi\nPol:199 | Amb:199 | Pom:199\n\n# Mali\nPol:17 | Amb:15 | Pom:18\n\n# Maroc\nPol:19 | Amb:15 | Pom:15\n\n# Maurice\nPol:999 | Amb:999 | Pom:999\n\n# Mauritanie\nPol:117 | Amb:Num�ro Local | Pom:118\n\n# Mayotte\nPol:112 | Amb:15 | Pom:603054\n\n# Mozambique\nPol:119 | Amb:117 | Pom:198\n\n# Namibie\nPol:1011 | Amb:2032276 | Pom:2032270\n\n# Niger\nPol:17 | Amb:723141 | Pom:18\n\n# Nig�ria\nPol:119 | Amb:199 | Pom:190\n\n# Ouganda\nPol:999 ou 111 portable | Amb:999 ou 111 portable | Pom:999 ou 111 portable\n\n# R�publique arabe sahraouie d�mocratique\nPol:-- | Amb:-- | Pom:--\n\n# R�publique centrafricaine\nPol:611253 | Amb:610600 | Pom:118\n\n# R�union\nPol:17 ou 112 portable | Amb:15 ou 112 portable | Pom:18 ou 112 portable\n\n# Rwanda\nPol:112 | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Sao Tom� et Principe\nPol:-- | Amb:-- | Pom:--\n\n# S�n�gal\nPol:Num�ro Local | Amb:8891515 | Pom:Num�ro Local\n\n# Seychelles\nPol:999 | Amb:999 | Pom:999\n\n# Sierra Leone\nPol:999 | Amb:999 | Pom:999\n\n# Somalie\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Soudan\nPol:999 | Amb:Num�ro Local | Pom:999\n\n# Swaziland\nPol:999 | Amb:6060911 | Pom:Num�ro Local\n\n# Tanzanie\nPol:112 | Amb:112 | Pom:112\n\n# Tchad\nPol:17 | Amb:Num�ro Local | Pom:18\n\n# Togo\nPol:101 | Amb:191 | Pom:118\n\n# Tunisie\nPol:197 | Amb:190 | Pom:198\n\n# Zambie\nPol:999 ou 112 portable | Amb:991 ou 112 portable | Pom:993 ou 112 portable\n\n# Zimbabwe\nPol:995 | Amb:994 | Pom:993");
			stringAsia = new StringItem("- Asie -", "\n# Afghanistan\nPol:-- | Amb:112 | Pom:--\n\n# Arabie saoudite\nPol:999 | Amb:997 | Pom:998\n\n# Arm�nie\nPol:102 | Amb:103 | Pom:101\n\n# Azerba�djan\nPol:102 | Amb:103 | Pom:101\n\n# Bahre�n\nPol:999 | Amb:999 | Pom:999\n\n# Bangladesh\nPol:8665513 | Amb:199 | Pom:9555555\n\n# Bhoutan\nPol:110 | Amb:112 | Pom:113\n\n# Brunei\nPol:993 | Amb:991 | Pom:995\n\n# Cambodge\nPol:117 | Amb:199 | Pom:118\n\n# Chine\nPol:110 | Amb:120 | Pom:119\n\n# Cor�e du Nord\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Cor�e du Sud (R�publique de Cor�e)\nPol:112 | Amb:119 | Pom:119\n\n# �mirats arabes unis\nPol:999 | Amb:998 | Pom:997\n\n# G�orgie\nPol:022 | Amb:022 | Pom:022\n\n# Hong Kong\nPol:999 | Amb:999 | Pom:999\n\n# Inde\nPol:100 | Amb:102 | Pom:101\n\n# Indon�sie\nPol:110 | Amb:118 | Pom:113\n\n# Iran\nPol:110 ou 112 portable  | Amb:115 ou 112 portable | Pom:125 ou 112 portable\n\n# Iraq\nPol:Pas de syst�me | Amb:Pas de syst�me | Pom:Pas de syst�me\n\n# Isra�l\nPol:100 | Amb:101 | Pom:102\n\n# Japon\nPol:110 | Amb:119 | Pom:119\n\n# Jordanie\nPol:192 | Amb:193 | Pom:193\n\n# Kazakhstan\nPol:03 | Amb:03 | Pom:03\n\n# Kirghizistan\nPol:133 | Amb:03 | Pom:03\n\n# Kowe�t\nPol:777 | Amb:777 | Pom:777\n\n# Kurdistan\nPol:129 | Amb:115 | Pom:125\n\n# Laos\nPol:Num�ro Local | Amb:03 | Pom:Num�ro Local\n\n# Liban\nPol:112 | Amb:140 | Pom:175\n\n# Macao\nPol:999 | Amb:999 | Pom:999\n\n# Malaisie\nPol:999 ou 112 portable | Amb:999 ou 112 portable | Pom:999 ou 112 portable\n\n# Maldives\nPol:119 | Amb:102 | Pom:118\n\n# Mongolie\nPol:102 | Amb:103 | Pom:101\n\n# Myanmar\nPol:199 | Amb:199 | Pom:199\n\n# N�pal\nPol:100 | Amb:228094 | Pom:101\n\n# Oman\nPol:999 | Amb:999 | Pom:999\n\n# Ouzb�kistan\nPol:03 | Amb:03 | Pom:03\n\n# Pakistan\nPol:15 | Amb:115 | Pom:16\n\n# Philippines\nPol:117 | Amb:117 | Pom:117\n\n# Qatar\nPol:999 | Amb:999 | Pom:999\n\n# Singapour\nPol:999 | Amb:995 | Pom:995\n\n# Sri Lanka\nPol:119 ou 112 portable | Amb:110 | Pom:111\n\n# Syrie\nPol:112 | Amb:110 | Pom:113\n\n# Tadjikistan\nPol:02 | Amb:03 | Pom:Num�ro Local\n\n# Taiwan\nPol:110 | Amb:119 | Pom:119\n\n# Tha�lande\nPol:191 ou 1155 (touristes) | Amb:191 | Pom:199\n\n# Timor oriental\nPol:112 | Amb:7233212 | Pom:--\n\n# Turkm�nistan\nPol:03 | Amb:03 | Pom:03\n\n# Vietnam\nPol:113 | Amb:115 | Pom:114\n\n# Y�men\nPol:199 | Amb:199 | Pom:199");
			stringEurope = new StringItem("- Europe -", "\n# Albanie\nPol:19 | Amb:17 | Pom:18\n\n# Allemagne\nPol:110 | Amb:112 | Pom:112\n\n# Andorre\nPol:110 | Amb:118 | Pom:118\n\n# Autriche\nPol:112 | Amb:112 | Pom:112\n\n# Belgique\nPol:112 | Amb:112 | Pom:112\n\n# Bi�lorussie\nPol:02 | Amb:03 | Pom:01\n\n# Bosnie-Herz�govine\nPol:122 | Amb:124 | Pom:123\n\n# Bulgarie\nPol:112 | Amb:112 | Pom:112\n\n# Chypre\nPol:112 | Amb:112 | Pom:112\n\n# Cit� du Vatican\nPol:112 | Amb:113 | Pom:115\n\n# Croatie\nPol:92 | Amb:94 | Pom:93\n\n# Danemark\nPol:112 | Amb:112 | Pom:112\n\n# Espagne\nPol:112 | Amb:112 | Pom:112\n\n# Estonie\nPol:112 | Amb:112 | Pom:112\n\n# Finlande\nPol:112 | Amb:112 | Pom:112\n\n# France\nPol:17 ou 112 | Amb:15 ou 112 | Pom:18 ou 112\n\n# Gr�ce\nPol:112 | Amb:112 | Pom:112\n\n# Hongrie\nPol:112 | Amb:112 | Pom:112\n\n# Irlande\nPol:112 | Amb:112 | Pom:112\n\n# Islande\nPol:112 | Amb:112 | Pom:112\n\n# Italie\nPol:112 | Amb:112 | Pom:112\n\n# Kosovo\nPol:911 | Amb:911 | Pom:911\n\n# Lettonie\nPol:112 | Amb:112 | Pom:112\n\n# Liechtenstein\nPol:112 | Amb:112 | Pom:112\n\n# Lituanie\nPol:112 | Amb:112 | Pom:112\n\n# Luxembourg\nPol:112 | Amb:112 | Pom:112\n\n# Mac�doine\nPol:112 | Amb:112 | Pom:112\n\n# Malte\nPol:112 | Amb:112 | Pom:112\n\n# Moldova\nPol:902 | Amb:903 | Pom:901\n\n# Monaco\nPol:112 | Amb:112 | Pom:112\n\n# Mont�n�gro\nPol:112 | Amb:112 | Pom:112\n\n# Norv�ge\nPol:112 | Amb:113 | Pom:110\n\n# Pays-Bas\nPol:112 | Amb:112 | Pom:112\n\n# Pologne\nPol:112 | Amb:112 | Pom:112\n\n# Portugal\nPol:112 | Amb:112 | Pom:112\n\n# R�publique tch�que\nPol:112 | Amb:112 | Pom:112\n\n# Roumanie\nPol:112 | Amb:112 | Pom:112\n\n# Royaume-Uni\nPol:112 | Amb:112 | Pom:112\n\n# Russie\nPol:02 | Amb:03 | Pom:01\n\n# Saint-Marin\nPol:112 | Amb:113 | Pom:116\n\n# Serbie\nPol:112 | Amb:112 | Pom:112\n\n# Slovaquie\nPol:112 | Amb:112 | Pom:112\n\n# Slov�nie\nPol:113 | Amb:112 | Pom:112\n\n# Su�de\nPol:112 | Amb:112 | Pom:112\n\n# Suisse\nPol:117 ou 112 | Amb: 144 ou 112 | Pom:118 ou 112\n\n# Turquie\nPol:155 | Amb:112 | Pom:110\n\n# Ukraine\nPol:112 | Amb:112 | Pom:112");
			stringNorthamerica = new StringItem("- Am�rique du Nord / Centrale -", "\n# Antigua-et-Barbuda\nPol:911 | Amb:911 | Pom:911\n\n# Bahamas\nPol:911 | Amb:911 | Pom:911\n\n# Barbade\nPol:112 | Amb:115 | Pom:113\n\n# Belize\nPol:911 | Amb:911 | Pom:911\n\n# Canada\nPol:911 | Amb:911 | Pom:911\n\n# Costa Rica\nPol:911 | Amb:911 | Pom:911\n\n# Cuba\nPol:26811 | Amb:26811 | Pom:26811\n\n# Dominique\nPol:999 | Amb:999 | Pom:999\n\n# El Salvador\nPol:911 | Amb:911 | Pom:911\n\n# �tats-Unis d'Am�rique\nPol:911 | Amb:911 | Pom:911\n\n# Grenade\nPol:112 | Amb:911 | Pom:911\n\n# Groenland\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Guatemala\nPol:110 | Amb:123 | Pom:122\n\n# Ha�ti\nPol:114 | Amb:118 | Pom:Num�ro Local\n\n# Honduras\nPol:119 | Amb:378654 | Pom:198\n\n# �les Ca�mans\nPol:911 | Amb:911 | Pom:911\n\n# Jama�que\nPol:119 | Amb:110 | Pom:110\n\n# Mexique\nPol:080 | Amb:060 | Pom:060\n\n# Nicaragua\nPol:118 | Amb:2651761 | Pom:2650162\n\n# Panama\nPol:104 | Amb:2699778 | Pom:103\n\n# R�publique dominicaine\nPol:911 | Amb:911 | Pom:911\n\n# Sainte-Lucie\nPol:999 | Amb:911 | Pom:911\n\n# Saint-Kitts-et-Nevis\nPol:911 | Amb:911 | Pom:911\n\n# Saint-Pierre-et-Miquelon\nPol:17 | Amb:15 | Pom:18\n\n# Saint-Vincent-et-les Grenadines\nPol:911 | Amb:911 | Pom:911\n\n# Trinit�-et-Tobago\nPol:999 | Amb:990 | Pom:990");
			stringOceania = new StringItem("- Oc�anie -", "\n# Australie\nPol:000 ou 112 portable | Amb:000 ou 112 portable | Pom:000 ou 112 portable\n\n# Fidji\nPol:911 | Amb:911 | Pom:9170\n\n# Iles Marshall\nPol:6258666 | Amb:6254111  | Pom:Num�ro Local\n\n# �les Salomon\nPol:911 | Amb:911 | Pom:911\n\n# Kiribati\nPol:Num�ro Local | Amb:994 | Pom:Num�ro Local\n\n# Micron�sie\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Nauru\nPol:Num�ro Local | Amb:Num�ro Local | Pom:Num�ro Local\n\n# Nouvelle-Z�lande\nPol:111 | Amb:111 | Pom:111\n\n# Palau\nPol:911 | Amb:911 | Pom:911\n\n# Papouasie-Nouvelle-Guin�e\nPol:000 | Amb:Num�ro Local | Pom:110\n\n# Samoa\nPol:995 | Amb:996 | Pom:994\n\n# Tonga\nPol:922 | Amb:933 | Pom:999\n\n# Tuvalu\nPol:911 | Amb:911 | Pom:911\n\n# Vanuatu\nPol:112 | Amb:112 | Pom:112");
			stringSouthamerica = new StringItem("- Am�rique du Sud -", "\n# Argentine\nPol:101 | Amb:107 | Pom:100\n\n# Bolivie\nPol:911 | Amb:911 | Pom:911\n\n# Br�sil\nPol:190 | Amb:192 | Pom:193\n\n# Chili\nPol:133 | Amb:131 | Pom:132\n\n# Colombie\nPol:119 | Amb:119 | Pom:119\n\n# Equateur\nPol:101 | Amb:131 | Pom:102\n\n# Guyana\nPol:911 | Amb:913 | Pom:912\n\n# Paraguay\nPol:911 | Amb:911 | Pom:911\n\n# P�rou\nPol:105 | Amb:116 | Pom:116\n\n# Suriname\nPol:115 | Amb:115 | Pom:115\n\n# Uruguay\nPol:911 | Amb:911 | Pom:911\n\n# Venezuela\nPol:171 | Amb:171 | Pom:171");

			// First-Aid-Text
			aid_disclaimer = new StringItem ("Responsabilit� + Info", "1. Logiciel\nPremiers Secours sur Portable\nVersion: j3.0\nDisponibilit�: 2008-12-24\nDroit d'auteur: Kai Kajus Noack\nTraduction: Sami Ben-Hassine\n\nLicence: Creative Commons by-nc-nd\n\nIllustrations � Med4Teens\n\nCe logiciel est cens� donner des informations sur les gestes de premiers secours. Toutefois, il ne se substitut pas � une formation aux premiers secours. Il sert plut�t au rafra�chissant des connaissances d�j� acquises.\n\n2. Responsabilit�\nS'il vous pla�t, notez que je ne prends aucune responsabilit� pour les cons�quences r�sultant de l'usage du logiciel.\nToute responsabilit� est exclue!\n� utiliser � vos propres risques!\n\nDans tous les cas d'urgence, s'il vous pla�t, chercher imm�diatement une aide m�dicale professionnelle.\n\n3. Projet de d�veloppement\nLe logiciel est cens� devenir multilingue. Traducteurs volontaires rechercher!\nDes informations compl�mentaires sont disponibles sur le site Internet www.firstai.de ou �crire un e-mail �: info@firstai.de\n\nSauver une vie c'est sauver le monde.");aid_general = new StringItem ("Conduite g�n�rale", "1. Toujours effectuer les gestes de premiers secours. Vous ne pouvez pas faire d'erreur.\n2. Toujours pr�ter attention � votre propre s�curit�.\n3. Examinez la situation et s�curisez le lieu de l'accident.\n4. Appelez les services d'urgences + les gestes de premiers secours!\n5. S'il y a plusieurs victimes, traiter en priorit� celle qui est la plus gravement bless�e.\n6. Toujours essayer de rassurez la personne concern�e. Restez calme vous m�me!\n7. Si possible, asseyez ou allongez la victime confortablement. Ne jamais donner d'alcool, de nicotine ou de la drogue � la victime.");aid_allergic = new StringItem ("Allergie", "1. Appelez imm�diatement une ambulance.\n2. Essayez de calmer la victime et laissez la s'asseoir confortable.\n3. Retirez avec soin l'origine de l'allergie (par exemple le dard de l'abeille).\n4. Refroidir la peau (compresse humide, glace sans contact direct avec la peau).\n5. Si la victime a un antidote, elle doit l'utiliser (l'aider).\n6. Veillez sur la victime jusqu'� l'arriv�e de l'ambulance.\n7. Si la victime perd conscience ou s'arr�te de respirer, voir les instructions appropri�es!");aid_animalbite = new StringItem ("Morsures d'animaux", "Attention: Danger �lev� d'infection. Cons�quences possibles: infection, t�tanos, rage.\n1. Lavez la plaie � l'eau chaude savonneuse.\n2. Ensuite, d�sinfectez la plaie.\n3. S'il y a h�morragie s�v�re, �lever le haut du corps de la personne.\n4. Mettre un pansement st�rile.\n5. Allez � l'h�pital ou appeler un m�decin d'urgence.");aid_apnoea = new StringItem ("Arr�t respiratoire", "Pas de son respiratoire, ou de mouvements respiratoire, notable changement de la coloration de la peau.\n1. Appelez les services d'urgence.\n2. Allongez la victime sur son dos.\n3. Retirer les substances se trouvant dans la bouche et la gorge. Basculez la t�te vers l'arri�re.\n4. Pincez le nez de sorte que le nez soit ferm�.\n5. Prenez une grande inspiration et mettre votre bouche sur la bouche de la victime de sorte que l'air ne s'�chappe pas.\n6. Expirez lentement et compl�tement.\n7. Si la victime ne se remet pas � respirer : continuez l'op�ration jusqu'� l'arriv�e de l'ambulance.");aid_asthma = new StringItem ("Asthme", "Fort essoufflement. Sifflements respiratoires. Anxi�t�.\n1. Rassurez la personne. Restez calme vous m�me!\n2. Desserrez les v�tements.\n3. Asseyez la victime et la pencher vers l'avant. Encouragez la victime � respirer lentement et profond�ment.\n4. Si la victime a un inhalateur, elle devrait l'utiliser (l'aider). Apr�s 5 � 10 min, cela devrait prendre effet.\n5. S'il n'y a pas d'am�lioration: Utiliser l'inhalateur toutes les 5 min jusqu'� l'arriv�e de l'ambulance.\n6. Appelez les services d'urgence.\n7. Si la victime arr�te de respirer, voir les instructions: Arr�t respiratoire.");aid_backinjury = new StringItem ("Dos - Blessure", "Douleur dans le dos, bras et jambes engourdis.\n1. Ne pas d�placer la victime!!\n2. Maintenez la t�te de la victime de fa�on � ce qu'elle ne bouge plus (garder la t�te stationnaire)\n3. Stabilisez la victime avec des v�tements ou autres sur les c�t�s.\n4. Rassurez la personne.\n5. Appelez les services d'urgence, leur indiquer l'emplacement de la blessure.");aid_birth = new StringItem ("Accouchement", "Perte des eaux. Contractions douloureuses. Accouchement inattendu.\n1. Ne pas exposer l'intimit� de la femme enceinte et gardez son calme! - Appelez les services d'urgence.\n2. Laissez les jambes � nu jusqu'� mi-cuisse et asseyez la femme enceinte sur une surface st�rile jambes �cart�es.\n3. Lui plier les genoux. Ecartez les jambes. Placez le bassin l�g�rement vers le haut. - La naissance est un processus naturel et fonctionne le plus souvent sans complications.\n4. Rassurez la femme enceinte, la laisser se concentrer sur sa respiration: Respirez par le nez, expirer par la bouche (� vitesse normale).\n5. Rythme � adopter: Prendre une grande inspiration, tenir le souffle, et pousser. D�s que la t�te du b�b� appara�t, la soutenir avec vos deux mains.\n6. Apr�s l'accouchement: Tenez le b�b� en oblique la t�te vers la bas pour lib�rer les voies respiratoires du liquide amniotique. (Il est possible que vous ayez � aspirer le fluide par le nez du b�b� avec votre bouche). Le b�b� doit respirer et pleurer!\n7. Lier le cordon ombilical � 30 cm du b�b� (peut aussi �tre fait � l'h�pital). Veillez � la st�rilit� du vagin de la m�re.\n8. S�chez le b�b� et le garder au chaud. Noter l'heure et les conduire � l'h�pital.");aid_bleedinglight = new StringItem ("Saignement l�ger", "Objectif: arr�ter le saignement.\n1. Ne pas toucher la plaie (risque d'infection).\n2. Ne pas traiter la plaie avec de la poudre, du baume ou de la cr�me ou encore avec un vaporisateur.\n3. Traitement des plaies: couvrir avec du mat�riel st�rile (compresse) et un bandage.\n4. Pour les petits saignements un pansement est souvent suffisant.\n5. Si la plaie est grande, utiliser une compresse et un bandage. Ne pas trop serrer le bandage, car un ralentissement de la circulation sanguine peut augmenter le saignement.\n6. Remarque: Les plaies dues � la morsure d'un animal enrag� doivent �tre lav�s avec une solution savonneuse.");aid_bleedingsevere = new StringItem ("Saignement grave", "Jet de sang, perte consid�rable de sang. Danger: perte de connaissance due � la perte de sang, infections, mort. Objectif: arr�ter l'h�morragie.\n1. Retirez les v�tements de la victime (les couper si n�cessaire) pour faire appara�tre la plaie.\n2. Bandez la plaie avec un bandage ou, si n�cessaire, un v�tement, et serrez fortement.\n3. Exercez une pression d'au moins 10 min.\n4. Si le bandage est imbib� de sang, ne pas le retirer. Mettre un bandage/v�tement suppl�mentaire.\n5. Positionnez le membre bless� (s'il n'est pas cass�) � une hauteur plus �lev�e que le c�ur afin de ralentir la circulation sanguine vers le membre bless�. Si possible, allongez la victime.\n6. Si le saignement ne s'arr�te pas, maintenir la pression sur la plaie et ajoutez des points de pression: Pour un saignement de l'avant-bras, compressez la partie sup�rieure du bras (compressez la veine situer sur la face interne du bras qui fait face au thorax). Pour un saignement de la jambe, compressez la partie sup�rieure de la jambe dans l'aine (compressez la veine situer entre les jambes sur la face interne de la jambe concern�e).\n7. Appelez les services d'urgence imm�diatement.\n8. D�s que le saignement est sous contr�le: Engager la mesure Anti-choc (Voir Choc).");aid_brainconcussion = new StringItem ("Commotion c�r�brale", "Maux de t�te, des naus�es, des vomissements. Affaiblissement de la vision. Possible perte de connaissance.\n1. Allongez la victime.\n2. Appelez les services d'urgence.\n\nSi saignement � la t�te:\n1. Allongez la victime et sur�lev�e la t�te (v�tement/oreiller).\n2. Traitez la plaie (utiliser un bandage/v�tement).\n3. Appelez les services d'urgence.");aid_burningslight = new StringItem ("Br�lure l�g�re", "Rougeur de la peau. L�ger gonflements. Douleur.\n1. Passez la zone concern�e sous l'eau froide.\n2. Mettre un bandage humide pas trop serr�.");aid_burningsevere = new StringItem ("Br�lure grave", "Peau blanche-rouge, boursouflures, �coulement de liquide. Dommages tissulaires profond. Forte douleur ou aucune douleur (� cause des nerfs br�l�s).\n1. Retirez les v�tements autant que possible.\n2. Refroidir les zones br�l�es avec de l'eau (environ 15 � C, 59 � F) pendant 10 min, jusqu'� ce que la douleur diminue.\n3. Si la br�lure est tr�s �tendue, utilisez des linges humides pour refroidir.\n4. Appelez les services d'urgence.\n5. Apr�s refroidissement, traitez la/les plaie(s): Utiliser un pansement/bandage st�rile. Ne pas appliquer de fluides (pas de cr�mes, huiles, etc.) Ne pas percer les cloques.\n6. Surveillez la respiration et l'�tat de conscience de la victime jusqu'� l'arriv�e du m�decin d'urgence.");aid_checkbreathing = new StringItem ("V�rifiez la respiration", "1. V�rifiez la respiration avec l'oreille sur le torse.\n2. V�rifiez la respiration sur le haut du torse (poser votre main sur le torse).\n3. Sentir la respiration par le nez et/ou la bouche de la victime avec votre joue.");aid_chemicalburneyes = new StringItem ("Br�lure chimique (yeux)", "1. Appelez les services d'urgence, leur indiquer les produits chimiques en question.\n2. Rincez les yeux avec beaucoup d'eau. Couvrir l'oeil en bonne sant� durant le rin�age.\n3. Conduire le jet d'eau � partir de l'angle interne de l'�il vers l'ext�rieur de l'�il. Rincez pendant au moins 20 minutes sous l'eau claire.\n4. Fermez les deux yeux de la victime et lui bandez les yeux avec un linge humide.\n5. Veillez sur la victime jusqu'� l'arriv�e de l'ambulance.");aid_chemicalburn = new StringItem ("Br�lure chimique", "Blessures des tissus.\n1. L'esprit d'autoprotection!\n2. Agir rapidement et lavez-les endroits br�l�s.\n3. Appelez les services d'urgence.\n4. S'il y a br�lure chimique dans les voies digestives, boire beaucoup d'eau.\n5. Ne pas provoquer de vomissements!");aid_dangerzone = new StringItem ("D�gagement d'urgence", "1. Ex�cution du d�gagement: Positionnez un bras de la victime sur sa poitrine, et mettez vous derri�re la victime.\n2. Passez vos mains sous les aisselles de la victime pour attraper le poignet et le coude du bras de la victime que vous avez mis sur sa poitrine.\n3. Retirez et transporter la personne en s�curit�.");aid_diabeticcoma = new StringItem ("Coma diab�tique", "Sucre dans le sang trop �lev� (manque d'insuline).\nSympt�mes: soif, perte contr�le vessie, naus�es, vomissements. Hal�ne � l'odeur de fruits/vin.\n1. Appelez les services d'urgence.\n2. Aidez la victime (si certitude diab�te) � prendre l'insuline.\n3. Position lat�rale de s�curit�. (Pas d'autres gestes possibilites pour le moment.)\n4. Surveiller l'�tat de la victime jusqu'� l'arriv�e de l'ambulance.");aid_diarrhoea = new StringItem ("Diarrh�es", "Intoxication alimentaire, infection de l'intestin ou troubles. Excr�ment liquide, visqueux ou sanglant.\n1. Danger pour la circulation sanguine en raison de la d�shydratation et la perte de sel!\n2. Faites boire (th�, eau).\n3. Si il y a de forts troubles appeler le m�decin d'urgence. Dans tous les cas, consulter un m�decin.");aid_drowning = new StringItem ("Noyade", "1. Appelez les services d'urgence. Demandez � c�t� de vous pour obtenir de l'aide.\n2. Sortez la victime de l'eau!\n3. Si la victime respire: Position lat�rale de s�curit�. Garder la victime au chaud (couverture). Surveiller la victime jusqu'� l'arriv�e de l'ambulance.\n4. Si victime ne respire pas: Commencez imm�diatement � la r�animation (Voir R�animation)! (�mission de l'eau des poumons est inutile.)");aid_electricityaccident = new StringItem ("�lectrocution", "1. Tout d'abord coupez l'�lectricit�!\nDanger: perte de conscience, arr�t respiratoire.\n2. A - Victime inconsciente / respire (Appelez les urgences)\n3. B - Victime inconsciente / ne respire pas (Voir v�rifiez la respiration + r�animation + appelez les Urgences)");aid_emergencycall = new StringItem ("Appelez les services d'urgence", "Appelez le 15 (112 � l'international). N'h�sitez pas � appeler une ambulance!\n\nAu t�l�phone, vous devez fournir les informations suivantes:\n- Que s'est-il pass� \n- O� (lieu de l'accident) \n- Combien de victimes \n- Quel type de blessures. \nEnsuite, attendre leurs instructions.");aid_epilepsy = new StringItem ("�pilepsie", "Corps rigide, poings serr�s, m�choire serr�e, contraction musculaires dans les membres ou le visage. Yeux retourn�s. Bave. Perte de connaissance possible.\n1. Ne pas tenir la victime ou restreindre ses mouvements.\n2. Allongez la victime sur une base souple (coussin), d�placez les objets proches pour �viter les blessures.\n3. Rassurez la victime. Desserrer les v�tements, assurez-vous qu'elle puisse respirer convenablement.\n4. Si la victime vomit, tournez la t�te sur le c�t� pour que le vomit se d�verse.\n5. Gardez les voies respiratoires libres. Risque d'avaler sa langue.\n6. Position lat�rale de s�curit� + appel des urgences. Continuez de surveiller l'�tat de la victime.\n7. Tenir les autres personnes � distance.");aid_eyeinjury = new StringItem ("Oeil - blessures", "1. Laissez l'objet dans l'�il de victime, ne pas le retirer.\n2. Gardez les yeux immobiles pour �viter de nouvelles blessures. Ne touchez pas les yeux.\n3. Si l'�il saigne, recouvrir d'une compresse ou d'une gaze st�rile.\n4. Refroidir les yeux avec un tampon froid (r�duit le gonflement, le saignement s'arr�te plus rapidement).\n5. Appelez les urgences ou allez en voiture � l'h�pital.");aid_fracture = new StringItem ("Fracture", "Sympt�mes: Forme et mouvement non naturel de l'os. D�formation. Mouvement douloureux, sensible au toucher.\n1. �vitez les mouvements!\n2. Appelez les services d'urgence.\n3. Immobilisez l'os fractur�, c'est-�-dire soutenir l'os � un objet en l'attachant solidement. Gardez la position naturelle de l'os.\n4. Si la fracture est ouverte, couvrir la plaie avec du mat�riel st�rile.");aid_frostbitemild = new StringItem ("Br�lure par le froid - l�ger", "P�leur, gonflements. Danger pour l'approvisionnement en sang.\n1. Emmenez la victime dans un endroit chaud.\n2. Eloignez vous du froid, retirer les v�tements froid, s�chez la victime.\n3. R�chauffez avec de l'eau ti�de et avec la chaleur du corps du sauveteur.\n4. Donnez une boisson chaude (th�). Pas d'alcool!");aid_frostbitesevere = new StringItem ("Br�lure par le froid - grave", "Peau froide, gris-blanc, cloque, tissu de peau mort. Danger pour l'approvisionnement en sang!\n1. Allez dans un endroit chaud.\n2. Traitement des plaies / les couvrir.\n3. Donnez une boisson sucr�e.\n4. Ne frottez pas la victime pour la r�chauffer!\n5. Appelez les services d'urgence.");aid_heartattack = new StringItem ("Crise Cardiaque", "Lourd, plus de 5 min de pression et de douleur dans la poitrine rayonnant dans les bras / �paules. Anxi�t�, p�leur, sueurs froides. Peut-�tre des naus�es, essoufflement.\n1. Appelez les urgences! Les informez d'une possible crise cardiaque.\n2. Sur�levez le haut du corps de la victime. Desserrez les v�tements. Ne donnez pas de m�dicaments ou de boissons.\n3. Parlez calmement � la victime.\n4. V�rifiez l'�tat de conscience et la respiration de la victime.\n5. Donnez de l'aspirine, si disponible.\n6. Si la personne est inconsciente, commencez la r�animation (voir R�animation).");aid_hypoglycaemia = new StringItem ("Hypoglyc�mie (faible teneur en sucre)", "Niveau de sucre dans le sang inf�rieur � la valeur minimum (� cause d'un surdosage d'insuline ou pas suffisamment d'apport en nourriture).\nSympt�mes: p�leur, nervosit�, faim, tremblements, sueur.\n1. Assurez-vous que la personne est une personne diab�tique (chercher un badge/carte diab�tique).\n2. Appelez les services d'urgences.\n3. Donner une boisson sucr�e et du dextrose ou glucose (si il n'y a pas de probl�mes de d�glutition).\n4. Si la personne est consciente et respire: position lat�rale de s�curit�. Surveiller la respiration de la personne. Si arr�t respiratoire: voir Arr�t respiratoire.\n5. Si la victime respire, vous pouvez mettre un morceau de sucre � l'int�rieur de la joue, fermez la bouche et poussez le sucre de l'ext�rieur.");aid_hyperthermia = new StringItem ("Hyperthermie (corps trop chaud)", "Soif, faiblesse, d�sorientation, naus�es, confusion, forte transpiration, la peau est chaude.\n1. Appelez les services d'urgence.\n2. Trouver un lieu ombrag� et frais (chambre avec air conditionn� pr�f�rable).\n3. Allongez la victime, �lever les jambes. Desserrez les v�tements.\n4. Refroidir la peau avec beaucoup d'eau ou couvrir avec des serviettes froides.\n5. Donnez beaucoup d'eau ou des jus de fruits � boire.");aid_hypothermia = new StringItem ("Hypothermie (corps trop froid)", "Tremble de froid, somnolence, �puisement jusqu'� l'inconscience. Peau froide et p�le. Faible pouls, rythme cardiaque faible.\n1. Emmenez la victime dans un endroit chaud.\n2. Appelez les services d'urgence.\n3. Augmenter la temp�rature du corps (couverture et corps � corps).\n4. Enlevez les v�tements mouill�s et mettre des v�tements chauds. Couvrir. Couvrir la t�te.\n5. Donnez du th� chaud, soupe ou de l'eau chaude � boire. Pas d'alcool! Gardez la victime �veill�e.\n6. Surveillez la victime jusqu'a l'arriv�e des services d'urgence. Si la victime perd conscience, proc�der � la r�animation (voir r�animation).\n7. A - Victime inconsciente / respire (Appelez les Urgences)\n8. B - Victime inconsciente / ne respire pas (Voir Arr�t respiratoire + les Urgences)");aid_icerescue = new StringItem ("Sauvetage sur glace", "Faites attention � votre propre s�curit�. Danger: noyade, hypothermie.\n1. Demandez � d'autres personnes de vous aider. Appelez les services d'urgence.\n2. Effectuez le sauvetage gr�ce � une �chelle, une planche ou une barre. Poids doit �tre r�parti de fa�on �gale.\n3. Ramper lentement vers la victime sur le support (si possible s'attacher avec une corde � un point stable) avec une barre ou autre.\n4. Atteindre la victime avec la barre ou autre (ne pas utiliser vos mains!) encouragez la � prendre l'objet et tirez la vers vous.\n5. Rampez lentement en arri�re.\n6. Gestes de premiers secours.\n7. Auto-�vacuation possible: Si la glace est solide, vous pouvez distribuer votre poids sur la glace et ramper � plat ventre, pour vous sortir de l'eau et vous diriger vers la terre ferme. Si la glace est fragile, essayer de la briser petit � petit jusqu'� la terre ferme.");aid_insectstings = new StringItem ("Piq�res d'insectes", "Gonflement, �ruption cutan�e, sensation de br�lure, faiblesse, respiration difficile, diminution de l'�tat de conscience, tachycardie.\n1. Retirez soigneusement le dard (avec une pince � �piler). Ne pas presser le dard car cela pourrait injecter plus de venin.\n2. Refroidir la zone concern�e (utilisez une compresse froide).\n3. La zone concern�e devrait �tre situ�e � une hauteur inf�rieure au c�ur pour ralentir la circulation du venin.\n4. Si piq�re dans la bouche/m�choire : Manger une glace et utilisez une compresse froide pour refroidir la gorge.\n5. Si de graves probl�mes apparaissent, probl�me de respiration ou perte de conscience, appelez une ambulance.");aid_nosebleeding = new StringItem ("Nez - saignement", "Rupture d'une petite art�re dans le bout du nez.\n1. Asseyez la victime, pench�e l�g�rement vers l'avant. Gardez la t�te droite.\n2. Ne pas allonger la victime, car avoir la t�te � une hauteur plus �lev�e que le coeur ralenti le saignement.\n3. Enveloppez le cou avec un linge froid (v�tement mouill�).\n4. Pincement des narines jusqu'� ce que le saignement s'arr�te (au moins 10 min).\n5. Ensuite, ne pas forcer sur le nez (ne pas renifler ou souffler fortement).\n6. Si de graves probl�mes apparaissent ou le saignement ne peut pas �tre arr�t�, appelez les Urgences.");aid_poisining = new StringItem ("Intoxication", "Confusion, hallucinations, pupille dilat�e, fi�vre, crampes. Perte de conscience.\n1. Donnez un antidote, uniquement si vous �tes accompagn� par un m�decin.\n2. Ne pas donner de boissons. Ne pas faire vomir.\n3. Appelez les Urgences + les inform�s de la nature de l'empoisonnement!\n4. Prot�gez la victime du reste de poison et des vomissements!\n5. Si la victime est consciente et respire: position lat�rale de s�curit�. Surveiller l'�tat de la victime jusqu'� l'arriv�e de l'ambulance.\n6. Si victime ne respire pas: commencer imm�diatement la R�animation! Vider la bouche de la victime avant de proc�der (vomit).");aid_recoveryposition = new StringItem ("Position lat�rale de s�curit�", "1. Allongez la victime sur le dos, jambes bien droite. Genoux coll�s.\n2. Placez le bras le plus proche de vous en angle droit par rapport au corps.\n3. Tirez le bras le plus �loign� de vous en travers de la poitrine et placez le dos de la main contre la joue proche de vous.\n4. Prenez le genou le plus �loign�, tirez-le vers vous, et posez le sur le sol. Mettre cette jambe en angle droit. Gardez la main de la victime sur sa joue, la paume doit toucher le sol et la t�te doit �tre pos� sur le dos de cette main.\n5. Assurez-vous que les voies respiratoires sont libres.\n6. Ouvrez l�g�rement la bouche et mettre la t�te l�g�rement en arri�re pour drainer la vomit. V�rifiez la respiration.\n7. Surveillez la victime jusqu'� l'arriv�e des Urgences.");aid_resuscitation = new StringItem ("R�animation", "# Massage Cardiaque\n1. Allongez la victime sur le dos. S'agenouiller � cot� d'elle.\n2. D�couvrir la poitrine.\n3. Placez la paume d'une main au milieu de la poitrine (au dessus du sternum).\n4. Placez la deuxi�me main sur la premi�re.\n5. Tendres les bras.\n6. Appuyez sur 5 cm de profondeur dans la poitrine de la victime (la puissance doit venir de la partie haute de votre corps) puis rel�cher.\n7. Pressez 30 fois de suite en peu de temps et fermement!\n\n# Bouche � bouche\n1. Enlevez les substances contenues dans la bouche et la gorge. Pivotez la t�te en arri�re.\n2. Pincez le nez de sorte � le fermer herm�tiquement.\n3. Prenez une grande inspiration et mettre votre bouche sur la bouche de la victime de sorte que l'air ne peut s'�chapper.\n4. Faire le bouche-�-bouche deux fois de suite (expirer lentement et enti�rement).\n5. Ensuite, faire le massage cardiaque � nouveau.\n\nR�p�tez le massage cardiaque et le bouche-�-bouche jusqu'� l'arriv�e de l'ambulance.");aid_safeguardaccident = new StringItem ("Accident de voiture", "1. Arr�tez votre propre voiture 50-100 m derri�re le site de l'accident (si vous �tes sur une autoroute ou route de campagne). Allumer les feux de d�tresse. Mettez votre gilet de haute visibilit�.\n2. Placez triangle de pr�signalisation avant l'accident. Attention: Si l'accident se trouve dans une courbe positionnez le triangle avant la courbe!\n3. Demandez de l'aide aux personnes autour de vous.\n4. Ouvrez la porte de la voiture accident�e (si bloqu�e, ouvrir � l'aide d'un cric de voiture). �teignez le moteur de la voiture.\n5. Secours aux victimes de l'accident: d�tachez la ceinture de s�curit�, d�placez le si�ge vers l'arri�re. Sortir la victime de la voiture gr�ce � la technique de d�gagement d'urgence.\n6. Appelez les services d'urgence.\n7. Commencez les gestes de premiers secours.");aid_shock = new StringItem ("Choc (H�morragies)", "Troubles de la circulation sanguine dus � un manque d'oxyg�ne dans le corps.\nCause: forte perte de sang, r�duction du volume sanguin.\nSympt�mes: p�leur, peau froide, sueur froide, anxi�t�.\n1. �liminer la cause du choc (par exemple, arr�ter la perte de sang, traitez la plaie)!\n2. D�posez la victime sur une couverture, �levez les jambes. Calmez la personne.\n3. Appelez les services d'urgence.\n4. Si difficult�s � respirer ou perte de conscience, commencez la r�animation.");aid_skullfracture = new StringItem ("Fracture du cr�ne", "L�ger saignement du nez, de la bouche ou des oreilles. Souvent, plaies ouvertes au cr�ne.\n1. Gardez les voies respiratoires libres.\n2. Si conscient: laissez la victime s'asseoir avec la t�te inclin� vers l'avant. �vitez de nouveaux mouvements!\n3. Si inconscient: position lat�rale de s�curit� (pas de pression sur la blessure de la t�te).\n4. Appelez les services d'urgence.\n5. Mettre un bandage sur la t�te.\n6. Si difficult�s � respirer ou perte de conscience, commencez la r�animation.");aid_snakebite = new StringItem ("Serpent - Morsures", "Plaie de la taille d'une �pingle, de fortes douleurs, gonflement, couleur pourpre. Troubles de la circulation sanguine, danger de mise en �tat de choc.\n1. Traitez les parties bless�es.\n2. Refroidir la zone autour de la morsure.\n3. Commencez les gestes Anti-chocs (Choc).\n4. Appelez les services d'urgence.");aid_sos = new StringItem ("SOS", "1. Signal: 3x court, 3xlong, 3x court.\n2. Visuel (laser de poche, lampe de poche), ou sonore (sifflet, frapper contre une surface).");aid_sprain = new StringItem ("Entorse", "Douleur, gonflements (bleu), perte de mobilit�, d�formation.\n1. Placez la partie bless�e du corps dans la position la plus confortable pour la victime.\n2. Refroidir (� l'aide de packs de glace).\n3. Si possible, �levez la partie bless�e.\n4. Allez � l'h�pital ou appelez les Urgences.");aid_stroke = new StringItem ("Vertige", "Sentiment de paralysie ou engourdissement subit (visage, bras, jambe), probl�mes de compr�hension, troubles de la vision, perte de conscience, forts maux de t�te. Probl�mes de respiration et de d�glutition, perte de contr�le de la vessie et des intestins.\n1. Appelez les services d'urgence!\n2. Desserrez les v�tements. Ne donner pas de m�dicaments ou de boissons.\n3. Asseyez ou allongez confortablement la victime. Rassurez la!\n4. Surveillez l'�tat de conscience et la respiration de la victime.\n5. Si difficult�s � respirer ou perte de conscience, commencez la r�animation.");aid_suffocation = new StringItem ("Etouffement", "Manque d'oxyg�ne. Trach�e ferm�e. Danger: arr�t respiratoire.\nSympt�mes: bruit respiratoire (sifflement), toux, essoufflement, d�coloration de la peau.\n1. Agir imm�diatement! Laissez la victime tousser tr�s fortement.\n2. Tapez fortement avec la paume de la main sur le dos entre les omoplates (allongez le b�b� sur votre avant-bras, la t�te en bas).\n3. Si, sans succ�s: Tenez-vous derri�re la victime, les bras autour de la taille, penchez-vous l�g�rement vers l'avant.\n4. Serrez votre poing � hauteur de l'estomac de la victime et prendre votre poing avec l'autre main.\n5. Utilisez les deux mains pour donner un coup sec dans l'estomac en ramenant vers le haut (comme vous le feriez pour essayer de lever la personne).\n6. R�p�tez cette manoeuvre jusqu'� 5 fois! Les voies respiratoires devraient �tre lib�r�es de l'objet.\n7. Appelez les services d'urgence.\n8. Si la premi�re tentative �choue, r�p�tez la manoeuvre jusqu'� l'arriv�e de l'ambulance.");aid_sunburn = new StringItem ("Coup de soleil", "1. D�placez la victime de la lumi�re directe du soleil. �viter de nouvelles expositions au soleil.\n2. Faire boire beaucoup d'eau pour arr�ter la d�shydratation.\n3. Si br�lure grave (cloques, rougeur, douleur), demandez un avis m�dical.\n4. Si la peau est l�g�rement rouge, elle peut �tre refroidi � l'aide de compresse humide. Utilisez une lotion ou gel de protection solaire.");aid_sunstroke = new StringItem ("Insolation", "T�te chaude, visage rouge, maux de t�te, vertiges. Cause: Irritation de la membrane c�r�brale.\n1. D�placez la victime dans un endroit frais (� l'ombre) et la partie sup�rieure du corps de la victime doit rester �lev�e.\n2. Refroidir la t�te avec des couvertures humides.\n3. Appelez les Urgences, Surveillez la respiration.\n4. Si conscient: Donnez une boisson fra�che le cas �ch�ant.\n5. Si arr�t respiratoire, voir r�animation\n6. Commencez le bouche-�-bouche!");aid_unconsciouswithbreath = new StringItem ("Inconscient avec respiration", "Victime ne r�agit pas lorsqu'on lui parle, pas de r�action lorsqu'on la secoue. Respiration existante.\n1. Si il y a des gens � c�t� de vous, demandez de l'aide.\n2. Position lat�rale de s�curit�. Ouvrir la bouche et positionnez la t�te de fa�on � laissez sortir le vomit.\n3. Appelez les services d'urgence.");aid_unconsciouswithoutbreath = new StringItem ("Inconscient sans respiration", "1. Pas de r�action de la victime, pas de respiration.\n\nCommencez la r�animation.");aid_vomiting = new StringItem ("Vomissements", "Provoqu� par des naus�es. L'estomac se vide. Causes: infections, intoxications, ulc�re, drogues/m�dicaments, mauvaise alimentation, grossesse.\n1. Danger pour la circulation sanguine en raison de la d�shydratation et la perte de sel!\n2. Faire boire (th�, eau).\n3. Si il y a de forts troubles, du sang ou des vomissements continus, appelez les Urgences.");
			aid_amputation = new StringItem ("Amputation", "Une partie du corps, amput�e, peut �tre rattach�e. Objectif: Conserver la partie amput�e dans le froid jusqu'� l�arriv�e � l'h�pital.\n1. Rassurez la victime, allongez la et la couvrir d�une couverture.\n2. Arr�tez l'h�morragie, voir 'Saignement grave' et 'Choc'. \n3. Emballez la partie amput�e dans un v�tement propre et sec et la mettre dans un sac en plastique �tanche.\n4. Fermez le sac en plastique et mettez-le dans un autre sac en plastique, qui contient de l'eau fra�che / glace.\n5. Ne donnez pas d'alcool, de cigarettes ou de la nourriture � la victime (dans le cas d'une intervention chirurgicale avec anesth�sie � l'h�pital).\n6. Ne pas congeler la partie amput�e (juste la tenir au frais).\n7. Appelez les Urgences ou allez en voiture � l'h�pital."); 
			separator = new StringItem ("Separator", "-");  
					// connection between MENU + NRs 
					stringItemArray = new StringItem[] {
							aid_disclaimer, separator, aid_general, aid_allergic, aid_safeguardaccident, aid_birth, aid_amputation, aid_emergencycall, aid_apnoea, aid_asthma, aid_chemicalburn, aid_chemicalburneyes, aid_burningsevere, aid_burningslight, aid_frostbitesevere, aid_frostbitemild, aid_shock, aid_diabeticcoma, aid_brainconcussion, aid_resuscitation, aid_sunburn, aid_heartattack, aid_dangerzone, aid_diarrhoea, aid_backinjury, aid_electricityaccident, aid_sprain, aid_epilepsy, aid_asthma, aid_suffocation, aid_fracture, aid_skullfracture, aid_backinjury, aid_diabeticcoma, aid_hyperthermia, aid_hypoglycaemia, aid_hypothermia, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_sunstroke, aid_poisining, aid_animalbite, aid_nosebleeding, aid_drowning, aid_eyeinjury, aid_insectstings, aid_recoveryposition, aid_resuscitation, aid_apnoea, aid_bleedingsevere, aid_bleedinglight, aid_icerescue, aid_snakebite, aid_sos, aid_checkbreathing, aid_stroke, aid_vomiting, separator}; 

			display = Display.getDisplay(this);
			display.setCurrent(this.menu);

			// sets the focus to the given index of the specified list.
			UiAccess.setCurrentListIndex(display, this.menu, 0);

			// set commands and listener to form
			details.addCommand(cmdBack);
			details.setCommandListener(this);

			// application has started
			started = true;
		}
	}


	public void applyText(int auswahl) {
		// clear form
		details.deleteAll();
		// assign title according title of menuItem 
		details.setTitle(UiAccess.getListItem(menu, menu.getSelectedIndex()).getText());
		// assign text according to int 'auswahl' 
		details.append(stringItemArray[auswahl].getText());

		// img:IMAGES
		
		// spacer
		details.append(""); 
		
		// img: CC licence
		if (auswahl==0) { details.append(imageCC); }
		// img:apnoea
		else if (auswahl==8 || auswahl==48) { details.append(aid067);
						  details.append(""); details.append(aid010);
						  details.append(""); details.append(aid011); }
		// img:backinjury
		else if (auswahl==24 || auswahl==32) { details.append(aid065); }
		// img:birth
		else if (auswahl==5) { details.append(aid025);
								details.append(""); details.append(aid022); 
								details.append(""); details.append(aid023); }
		// img:chemicalburneyes
		else if (auswahl==11) { details.append(aid019); }
		// img:bleedinglight
		else if (auswahl==50) { details.append(aid084);
							    details.append(""); details.append(aid085); }
		// img:bleedingsevere
		else if (auswahl==49) { details.append(aid084);
							    details.append(""); details.append(aid085);
							    details.append(""); details.append(aid089);
							    details.append(""); details.append(aid092); }
		// img:brainconcussion
		else if (auswahl==18) { details.append(aid061); }
		// img:dangerzone
		else if (auswahl==22) { details.append(aid001); }
		// img:drowning
		else if (auswahl==43) { details.append(aid034); }
		// img:electricityaccident
		else if (auswahl==25) { details.append(aid045); }
		// img:epilepsy
		else if (auswahl==27) { details.append(aid058); }
		// img:fracture
		else if (auswahl==28) { details.append(aid107); }
		// img:heartattack
		else if (auswahl==21) { details.append(aid061); }
		// img:icerescue
		else if (auswahl==51) { details.append(aid041); }
		// img:recoveryposition
		else if (auswahl==46) { details.append(aid008); 
							  details.append(""); details.append(aid009); 
							  details.append("\nPosition lat�rale de s�curit� (pour b�b�):"); details.append(aid028); }
		// img:resuscitation (FR: removed one)
		else if (auswahl==19 || auswahl==47) { 
							  details.append(aid013);
							  details.append(""); details.append(aid003); 
							  details.append(""); details.append(aid067); 
							  details.append(""); details.append(aid010); 
							  details.append(""); details.append(aid011); 
							  details.append(""); details.append(aid012);
							  details.append("\n\n# R�animation (B�b�)\n\nUtiliser seulement deux doigts:"); details.append(aid029); 
							  details.append("\nNe pas expirer trop fort:"); details.append(aid030); }
		// img:safeguardaccident (FR: removed one)
		else if (auswahl==4) { details.append(aid001); }
		// img:suffocation (FR: removed one)
		else if (auswahl==30) { details.append(aid031); 
							  details.append(""); details.append(aid069); }
		// img:sunstroke
		else if (auswahl==39) { details.append(aid061); }
		// img: unconsciouswithbreath
		else if (auswahl==37) { details.append(aid008); 
							  details.append(""); details.append(aid009); }
		
		// spacer below
		details.append("");

		// append Resuscitation measures!
		// for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
		if (auswahl==38 || auswahl==43 || auswahl==21 || auswahl==18 || auswahl==55 || auswahl==16 || auswahl==40) { 
			details.append(aid_resuscitation);
			  details.append(aid013);
			  details.append(""); details.append(aid003);  details.append(""); details.append(aid067); 
			  details.append(""); details.append(aid010);  details.append(""); details.append(aid011); 
			  details.append(""); details.append(aid012);
		}
		// for electricity / hypothermia
		else if (auswahl==25 || auswahl==36) { 
			details.append(aid_unconsciouswithbreath); 
			details.append("");
			details.append(aid_unconsciouswithoutbreath); 
			details.append("");
			details.append(aid_resuscitation); 
			  details.append(""); details.append(aid003);   details.append(""); details.append(aid067); 
			  details.append(""); details.append(aid010);   details.append(""); details.append(aid011); 
		} // for sunstroke / asthma / hypoglycaemia
		else if (auswahl==39 || auswahl==9 || auswahl==35) { 
			details.append(aid_apnoea);
			details.append(""); details.append(aid010);	
			details.append(""); details.append(aid011); 
		}
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	public void commandAction(Command c, Displayable d) {
		// System.out.println(c.getLabel());
		if(c.getCommandType() == Command.BACK) {
			display.setCurrent(menu);
		}
		else if (c.getCommandType() == Command.EXIT) {
			notifyDestroyed();
		}
		// Country Emergency Menu
		else if (display.getCurrent().getTitle() == telEmergency.getTitle()) {
			details.deleteAll();
			details.setTitle(UiAccess.getListItem(telEmergency, telEmergency.getSelectedIndex()).getText());
			if (telEmergency.getSelectedIndex() == 0) { details.append(stringAfrica); } 
			else if (telEmergency.getSelectedIndex() == 1) { details.append(stringNorthamerica); }
			else if (telEmergency.getSelectedIndex() == 2) { details.append(stringSouthamerica); }
			else if (telEmergency.getSelectedIndex() == 3) { details.append(stringAsia); }
			else if (telEmergency.getSelectedIndex() == 4) { details.append(stringEurope); }
			else if (telEmergency.getSelectedIndex() == 5) { details.append(stringOceania); }
			display.setCurrent(details);
		}
		// Main Menu
		else if (display.getCurrent().getTitle() == menu.getTitle()) {
			if (menu.getSelectedIndex() == 1) { 
				display = Display.getDisplay(this);
				display.setCurrent(telEmergency);
			}
			// catch divider
			else if (menu.getSelectedIndex() == 57) { }
			// notruf
			else if (menu.getSelectedIndex() == 58) {
				try {
					platformRequest("tel:112");
					// http://developers.sun.com/mobility/midp/ttips/platformRequest/index.html
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			else {
				// apply text to form and show it
				applyText(menu.getSelectedIndex());
				display = Display.getDisplay(this);
				display.setCurrent(details);
			}
		}
	}
}
