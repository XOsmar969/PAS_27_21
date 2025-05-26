public class HomeFragment extends Fragment {

    private RecyclerView rvTeams;
    private ProgressBar progressBar;
    private TeamAdapter teamAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvTeams = view.findViewById(R.id.rvTeams);
        progressBar = view.findViewById(R.id.progressBar);

        rvTeams.setLayoutManager(new LinearLayoutManager(getContext()));

        teamAdapter = new TeamAdapter(new ArrayList<>()); // Pasang adapter kosong dulu
        rvTeams.setAdapter(teamAdapter);

        fetchData();

        return view;
    }

    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<TeamResponse> call = apiService.getTeams("Spanish La Liga");

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    teamAdapter.setTeams(response.body().getTeams());
                    teamAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data: Response error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Gagal mengambil data: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
