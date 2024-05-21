class BookSummary {
    private String groupName;
    private long totalBook;
    private long sumBookPrice;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String groupName;
        private long totalBook;
        private long sumBookPrice;

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder totalBook(long totalBook) {
            this.totalBook = totalBook;
            return this;
        }

        public Builder sumBookPrice(long sumBookPrice) {
            this.sumBookPrice = sumBookPrice;
            return this;
        }

        public BookSummary build() {
            BookSummary summary = new BookSummary();
            summary.groupName = this.groupName;
            summary.totalBook = this.totalBook;
            summary.sumBookPrice = this.sumBookPrice;
            return summary;
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public long getTotalBook() {
        return totalBook;
    }

    public long getSumBookPrice() {
        return sumBookPrice;
    }
}

interface BookRepo {
    long countBookGroupByCategory(BookReq req);

    long sumBookPriceGroupByCategory(BookReq req);

    long countBookGroupByAuthor(BookReq req);

    long sumBookPriceGroupByAuthor(BookReq req);

    long countBookGroupByDateReleased(BookReq req);

    long sumBookPriceGroupByDateReleased(BookReq req);
}

class BookRepoImpl implements BookRepo {
    @Override
    public long countBookGroupByCategory(BookReq req) {
        // Implementasi dummy
        return 100;
    }

    @Override
    public long sumBookPriceGroupByCategory(BookReq req) {
        // Implementasi dummy
        return 5000;
    }

    @Override
    public long countBookGroupByAuthor(BookReq req) {
        // Implementasi dummy
        return 200;
    }

    @Override
    public long sumBookPriceGroupByAuthor(BookReq req) {
        // Implementasi dummy
        return 10000;
    }

    @Override
    public long countBookGroupByDateReleased(BookReq req) {
        // Implementasi dummy
        return 150;
    }

    @Override
    public long sumBookPriceGroupByDateReleased(BookReq req) {
        // Implementasi dummy
        return 7500;
    }
}

interface BookGroupStrategy {
    BookSummary getBookSummary(BookReq req);
}

class BookSummaryByCategory implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByCategory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByCategory(req);
        long sum = bookRepo.sumBookPriceGroupByCategory(req);
        return BookSummary.builder()
                .groupName("By Category")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryByAuthor implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByAuthor(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByAuthor(req);
        long sum = bookRepo.sumBookPriceGroupByAuthor(req);
        return BookSummary.builder()
                .groupName("By Author")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryByReleasedDate implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByReleasedDate(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByDateReleased(req);
        long sum = bookRepo.sumBookPriceGroupByDateReleased(req);
        return BookSummary.builder()
                .groupName("By Release Date")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookGroupFactory {
    private final BookRepo bookRepo;

    public BookGroupFactory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookGroupStrategy buildStrategy(String grouping) throws Exception {
        switch (grouping) {
            case "category":
                return new BookSummaryByCategory(bookRepo);
            case "dateReleased":
                return new BookSummaryByReleasedDate(bookRepo);
            case "author":
                return new BookSummaryByAuthor(bookRepo);
            default:
                throw new Exception("No grouping found");
        }
    }
}

class BookReq {
    private String grouping;

    public BookReq(String grouping) {
        this.grouping = grouping;
    }

    public String getGrouping() {
        return grouping;
    }
}

class BookSummaryService {
    private final BookRepo bookRepo;

    public BookSummaryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void printSummary(BookReq req) throws Exception {
        BookGroupFactory bookGroupFactory = new BookGroupFactory(bookRepo);
        BookGroupStrategy strategy = bookGroupFactory.buildStrategy(req.getGrouping());

        BookSummary books = strategy.getBookSummary(req);
        System.out.println("groupName = " + books.getGroupName());
        System.out.println("total = " + books.getTotalBook());
        System.out.println("sum price = " + books.getSumBookPrice());
    }
}

class OpenClose {
    public static void main(String[] args) {
        BookRepo bookRepo = new BookRepoImpl(); // Implementasi konkret dari BookRepo
        BookSummaryService summaryService = new BookSummaryService(bookRepo);

        try {
            // Contoh request dengan grouping "category"
            BookReq categoryReq = new BookReq("category");
            summaryService.printSummary(categoryReq);

            // Contoh request dengan grouping "dateReleased"
            BookReq dateReleasedReq = new BookReq("dateReleased");
            summaryService.printSummary(dateReleasedReq);

            // Contoh request dengan grouping "author"
            BookReq authorReq = new BookReq("author");
            summaryService.printSummary(authorReq);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}