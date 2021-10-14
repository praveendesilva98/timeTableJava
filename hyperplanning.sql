-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 07 juin 2020 à 16:04
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `hyperplanning`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id`, `nom`) VALUES
(1, 'Mathématiques'),
(2, 'Informatique'),
(3, 'Physique'),
(5, 'Traitement de signal'),
(6, 'Anglais'),
(7, 'Droit du travail'),
(8, 'Thermodynamique'),
(9, 'Robotique'),
(10, 'Théorie des graphes');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id_utilisateur` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id_utilisateur`, `id_cours`) VALUES
(65, 2),
(66, 1),
(67, 2),
(68, 3),
(69, 7),
(70, 10),
(71, 8),
(72, 8),
(73, 3),
(74, 5),
(75, 5),
(76, 6),
(77, 6),
(78, 9),
(79, 9);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(20) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id_utilisateur`, `numero`, `id_groupe`) VALUES
(80, 123456789, 1),
(81, 987654321, 9),
(82, 654123789, 13),
(85, 15975364, 15);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `id_promo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`id`, `nom`, `id_promo`) VALUES
(1, 'TD 5', 3),
(2, 'TD 9', 1),
(4, 'TD 5', 2),
(5, 'TD 2', 2),
(6, 'TD1', 3),
(7, 'TD2', 3),
(8, 'TD3', 3),
(9, 'TD4', 3),
(10, 'TD10', 1),
(11, 'TD11', 1),
(12, 'TD8', 1),
(13, 'TD6', 2),
(14, 'TD4', 2),
(15, 'TD3', 2);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id_promotion` int(11) NOT NULL AUTO_INCREMENT,
  `nom_promotion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id_promotion`, `nom_promotion`) VALUES
(1, '2020'),
(2, '2021'),
(3, '2022'),
(5, '2023');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int(11) NOT NULL AUTO_INCREMENT,
  `nom_salle` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  `id_site` int(11) NOT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id_salle`, `nom_salle`, `capacite`, `id_site`) VALUES
(1, 'P404', 50, 2),
(2, 'P416', 40, 2),
(5, 'G014', 40, 4),
(6, 'G016', 40, 4),
(7, 'G017', 40, 4),
(8, 'P304', 80, 2),
(9, 'P305', 45, 2),
(10, 'P306', 25, 2),
(11, 'P307', 40, 2),
(12, 'P345', 40, 2),
(13, 'P346', 30, 2),
(14, 'P347', 40, 2),
(15, 'P348', 35, 2),
(16, 'EM110', 150, 3),
(17, 'EM001', 150, 3),
(18, 'EM005', 150, 3),
(19, 'A101', 40, 11),
(20, 'A110', 40, 11),
(21, 'A001', 20, 11);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `id_seance` int(11) NOT NULL AUTO_INCREMENT,
  `semaine` int(11) NOT NULL,
  `date` date NOT NULL,
  `heure_debut` varchar(255) NOT NULL,
  `heure_fin` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `id_cours` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignant`
--

DROP TABLE IF EXISTS `seance_enseignant`;
CREATE TABLE IF NOT EXISTS `seance_enseignant` (
  `id_seance` int(11) NOT NULL AUTO_INCREMENT,
  `id_enseignant` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`,`id_enseignant`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `seance_enseignant`
--

INSERT INTO `seance_enseignant` (`id_seance`, `id_enseignant`) VALUES
(2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupe`
--

DROP TABLE IF EXISTS `seance_groupe`;
CREATE TABLE IF NOT EXISTS `seance_groupe` (
  `id_seance` int(11) NOT NULL AUTO_INCREMENT,
  `id_groupe` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`,`id_groupe`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `seance_groupe`
--

INSERT INTO `seance_groupe` (`id_seance`, `id_groupe`) VALUES
(3, 0);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salle`
--

DROP TABLE IF EXISTS `seance_salle`;
CREATE TABLE IF NOT EXISTS `seance_salle` (
  `id_seance` int(11) NOT NULL AUTO_INCREMENT,
  `id_salle` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`,`id_salle`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `seance_salle`
--

INSERT INTO `seance_salle` (`id_seance`, `id_salle`) VALUES
(2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id`, `nom`) VALUES
(2, 'Eiffel 2'),
(3, 'Eiffel 3'),
(4, 'Eiffel 4'),
(10, 'Eiffel 1'),
(11, 'Eiffel 5');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`id`, `nom`) VALUES
(1, 'TD'),
(2, 'TP'),
(3, 'Cours Interactif'),
(4, 'Projet'),
(5, 'Soutien');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `droit` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `password`, `nom`, `prenom`, `droit`) VALUES
(65, 'manolo.hina@ece.fr', 'manoloh', 'Hina', 'Manolo', 3),
(66, 'fabienne.coudray@ece.fr', 'fabcou', 'Coudray', 'Fabienne', 3),
(67, 'jp.segado@ece.fr', 'jpseg', 'Segado', 'Jean-Pierre', 3),
(68, 'waleed.mouhali@ece.fr', 'walmou', 'Mouhali', 'Waleed', 3),
(69, 'yves.maupile@ece.fr', 'yves', 'Maupile', 'Yves', 3),
(70, 'elisabeth.rendler@ece.fr', 'elisrend', 'Rendler', 'Elisabeth', 3),
(71, 'michel.pullicino@ece.fr', 'michelpul', 'Pullicino', 'Michel', 3),
(72, 'thomas.guillemot@ece.fr', 'thomas', 'Guillemot', 'Thomas', 3),
(73, 'christine.crambe@ece.fr', 'chriscram', 'Crambe', 'Christine', 3),
(74, 'arash.mokhber@ece.fr', 'arashmok', 'Mokhber', 'Arash', 3),
(75, 'boubezoulr@ece.fr', 'abdebou', 'Boubezoul', 'Abderrahmane', 3),
(76, 'carly@ece.fr', 'carlyaa', 'Assael - Alexander', 'Carly', 3),
(77, 'marie.leonard@ece.fr', 'marieleo', 'Leonard', 'Marie', 3),
(78, 'nassima.nacer@ece.fr', 'nasnac', 'Nacer', 'Nassima', 3),
(79, 'thierry.minot@ece.fr', 'thiemin', 'Minot', 'Thierry', 3),
(80, 'pierre.moreau2@edu.ece.fr', 'pierremo', 'Moreau', 'Pierre', 4),
(81, 'praveen.dasilva@ece.fr', 'prada', 'Da Silva', 'Praveen', 4),
(82, 'darokous.mendes@ece.fr', 'mendes01', 'Mendes', 'Darokous', 4),
(83, 'romain.beau@ece.fr', 'romainbeau', 'Beau', 'Romain', 1),
(84, 'tom.cassis@ece.fr', 'tomcassis', 'Cassis', 'Tom', 2),
(85, 'lucas.raton@ece.fr', 'lucasraton', 'Raton', 'Lucas', 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
