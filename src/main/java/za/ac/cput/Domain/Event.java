package za.ac.cput.Domain;
/* Event.java
   Event model class
   Author: Simphiwe Thwabuse(220246009)
   Date: 25 March 2025
 */
    public class Event {
        private String eventId;
        private String title;
        private String date;
        private String location;
        private int targetAmount;
        private int currentAmount;

        private Event() {

        }

        public Event(Builder builder) {
            this.eventId = builder.eventId;
            this.title = builder.title;
            this.date = builder.date;
            this.location = builder.location;
            this.targetAmount = builder.targetAmount;
            this.currentAmount = builder.currentAmount;

        }

        public String getEventId() {
            return eventId;
        }

        public String getTitle() {
            return title;
        }

        public String getDate() {
            return date;
        }

        public String getLocation() {
            return location;
        }

        public int getTargetAmount() {
            return targetAmount;
        }

        public int getCurrentAmount() {
            return currentAmount;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "eventId='" + eventId + '\'' +
                    ", title='" + title + '\'' +
                    ", date='" + date + '\'' +
                    ", location='" + location + '\'' +
                    ", targetAmount=" + targetAmount +
                    ", currentAmount=" + currentAmount +
                    '}';
        }

        public static class Builder {
            private String eventId;
            private String title;
            private String date;
            private String location;
            private int targetAmount;
            private int currentAmount;

            public Builder setEventId(String eventId) {
                this.eventId = eventId;
                return this;
            }

            public Builder setTitle(String title) {
                this.title = title;
                return this;
            }

            public Builder setDate(String date) {
                this.date = date;
                return this;

            }

            public Builder setLocation(String location) {
                this.location = location;
                return this;
            }

            public Builder setTargetAmount(int targetAmount) {
                this.targetAmount = targetAmount;
                return this;
            }


            public Builder setCurrentAmount(int currentAmount) {
                this.currentAmount = currentAmount;
                return this;
            }

            public Builder copy(Event event) {
                this.eventId = event.eventId;
                this.title = event.title;
                this.date = event.date;
                this.location = event.location;
                this.targetAmount = event.targetAmount;
                this.currentAmount = event.currentAmount;
                return this;
            }

            //takes a builder object, make new event and return it.
            public Event build() {
                return new Event(this);
            }
        }

    }


