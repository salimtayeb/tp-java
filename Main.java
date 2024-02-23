import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Boutique boutique = new Boutique();
        System.out.println("Bienvenue dans ma boutique ");

        
        boutique.addProduit(new ProduitElectronique("Télévision", "Samsung", 800, 24));
        boutique.addProduit(new ProduitAlimentaire("Chocolat", "Chocolat noir", 5, LocalDate.of(2024, 12, 31)));
        boutique.addProduit(new ProduitBoisson("Coca-Cola", "Boisson gazeuse", 2, 330));

        
        System.out.println("Les produits disponibles dans ma boutique sont:");
        for (Produit produit : boutique.getProduits()) {
            produit.afficher();
            System.out.println();
        }

        
        Panier panier = new Panier();
        panier.ajouterProduit(new ProduitElectronique("Ordinateur portable", "PC portable 15 pouces", 1200, 12));
        panier.ajouterProduit(new ProduitAlimentaire("Pain", "Pain de campagne", 1, LocalDate.of(2024, 2, 23)));
        panier.ajouterProduit(new ProduitBoisson("Eau minérale", "Eau plate", 1, 500));

        
        System.out.println("\nLe prix total du panier est de: " + panier.prixTotalPanier() + " euros.");
    }
}

class Produit {
    private String nom;
    private String description;
    private int prix;

    public Produit(String nom, String description, int prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void afficher() {
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Prix: " + prix);
    }
}

class ProduitElectronique extends Produit {
    private int dureeGarantie;

    public ProduitElectronique(String nom, String description, int prix, int dureeGarantie) {
        super(nom, description, prix);
        this.dureeGarantie = dureeGarantie;
    }

    public int getDureeGarantie() {
        return dureeGarantie;
    }

    public void setDureeGarantie(int dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public void afficher() {
        super.afficher();
        System.out.println("Durée de garantie: " + dureeGarantie + " mois");
    }
}

class ProduitAlimentaire extends Produit {
    private LocalDate dateExpiration;

    public ProduitAlimentaire(String nom, String description, int prix, LocalDate dateExpiration) {
        super(nom, description, prix);
        this.dateExpiration = dateExpiration;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    
    public void afficher() {
        super.afficher();
        System.out.println("Date d'expiration: " + dateExpiration);
    }
}

class ProduitBoisson extends Produit {
    private int quantite;

    public ProduitBoisson(String nom, String description, int prix, int quantite) {
        super(nom, description, prix);
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void afficher() {
        super.afficher();
        System.out.println("Quantité: " + quantite + " cl");
    }
}

class Boutique {
    private List<Produit> produits;

    public Boutique() {
        this.produits = new ArrayList<>();
    }

    public void addProduit(Produit produit) {
        produits.add(produit);
    }

    public List<Produit> getProduits() {
        return produits;
    }
}

class Panier {
    private List<Produit> produits;

    public Panier() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public int prixTotalPanier() {
        int prixTotal = 0;
        for (Produit produit : produits) {
            prixTotal += produit.getPrix();
        }
        return prixTotal;
    }
}
