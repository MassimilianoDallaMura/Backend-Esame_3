package services;

import dao.CatalogItemDao;
import entity.CatalogItem;

import java.util.List;

public class CatalogService {
    private CatalogItemDao catalogItemDao;

    public CatalogService(CatalogItemDao catalogItemDao) {
        this.catalogItemDao = catalogItemDao;
    }

    public void addItem(CatalogItem item) {
        catalogItemDao.addItem(item);
    }

    public void removeItemByIsbn(String isbn) {
        catalogItemDao.removeItemByIsbn(isbn);
    }

    public CatalogItem getItemByIsbn(String isbn) {
        return catalogItemDao.getItemByIsbn(isbn);
    }

    public List<CatalogItem> searchByPublicationYear(int year) {
        return catalogItemDao.searchByPublicationYear(year);
    }

    public List<CatalogItem> searchByAuthor(String author) {
        return catalogItemDao.searchByAuthor(author);
    }

    public List<CatalogItem> searchByTitle(String title) {
        return catalogItemDao.searchByTitle(title);
    }
}
