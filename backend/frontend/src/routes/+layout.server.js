/** @type {import('./$types').LayoutServerLoad} */
export async function load({ cookies }) {
  const token = cookies.get('token') ?? null;
  console.log(token);
  if (token != null) {
    const res = await fetch(`https://3.27.115.22.nip.io:8443/user?token=${token}`);
    const item = await res.json();

    return { item };
  }
}
