package intellispaces.samples.rdb;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;
import intellispaces.ixora.rdb.annotation.Entity;
import intellispaces.ixora.rdb.annotation.Query;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "book", name = "book_order")
@Domain("d278ea68-26a3-4b78-901e-92b6f64d3b15")
public interface OrderDomain {

  @Id
  @Column(name = "id")
  @Transition("019020aa-06cf-41e3-b378-df0e7ad67728")
  int id();

  @Column(name = "book_id")
  @Transition("31ab0d59-c950-4941-8597-799043550f43")
  int bookId();

  @OneToOne
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  @Transition("db9dc28d-6cfa-4688-879e-8449d9dfa6d3")
  BookDomain book();

  @Basic
  @Query("SELECT COUNT(*) FROM book_order bo WHERE bo.book_id = :this.bookId")
  @Transition("686b6e22-13a2-45e2-988b-8fb166b77fb2")
  int totalCountOrderThisBook();

  @Column(name = "price")
  @Transition("a9fb5771-8d2c-473d-8129-f7e3a34fa5a4")
  int price();
}
